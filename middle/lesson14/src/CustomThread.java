import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomThread {
    int counter1 = 0;
    public synchronized void incrementCounter1 (){
        counter1++;
    }

    int counter2 = 0;
    public void incrementCounter2 (){
        synchronized (this){
            counter2++;
        }
    }

    AtomicInteger counter3 = new AtomicInteger(0);
    public void incrementCounter3 (){
        counter3.incrementAndGet();
    }

    int counter4 = 0;
    boolean isIncrementing = false;
    public synchronized void incrementCounter4 (){
        while(isIncrementing){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isIncrementing = true;
        for(int i = 0; i < 10000; i++){
            counter4++;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isIncrementing = false;
        notify();
    }


    public static void main(String[] args) throws InterruptedException {
        CustomThread customThread = new  CustomThread();
        Lock lock = new ReentrantLock();
        Semaphore semaphore =new Semaphore(2);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Exchanger<Integer> exchanger = new Exchanger<>();
        System.out.println(Thread.currentThread().getName());
        // ������� �������� �������
        // � ������� ������ ������������ �� Thread----------------------------------------------------------------------
        FirstThread thread1 = new FirstThread();
        // � ������� ������ ������������ ��  lambda ����������----------------------------------------------------------
        Thread thread2 = new Thread(new SecondThread());
        // � ������� ���������� � ��������� �������� lambda ����������--------------------------------------------------
        Thread thread3 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Hello it's thread3");
            }
        });
        // � ������� ���������� � ������� lambda ���������--------------------------------------------------------------
        Thread thread4 = new Thread(() -> System.out.println("Hello it's thread4"));

        //������������� ��������� �������(����)-------------------------------------------------------------------------
        Thread.sleep(1000);

        // ������ ������------------------------------------------------------------------------------------------------
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // NB! �������� �1: ������������� ��������� ���������� ��������� ������
        // ���� ������ �� �������� ���� �������� (������ ����� main)----------------------------------------------------
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        // �������� (����������) ��� ������-----------------------------------------------------------------------------
        System.out.println(thread1.getName());
        thread1.setName("Custom_thread_name");
        System.out.println(thread1.getName());

        // �������� (����������) ��������� ������----------------------------------------------------------------------
        System.out.println(thread1.getPriority());
        thread1.setPriority(10); // 10 ������������
        System.out.println(thread1.getPriority());


        // NB! �������� �1�: Data race ��������� ������ ����� �������� ������������ (Data Race)
        // (������� 1 - ����������� ������ � ������ �������� ��������� synchronized, ���������� �������� �������)-------

        Thread thread5 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                customThread.incrementCounter1();
            }
        });
        Thread thread6 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                customThread.incrementCounter1();
            }
        });
        thread5.start();
        thread6.start();
        thread5.join();
        thread6.join();


        // NB! �������� �1�: Data race ��������� ������ ����� �������� ������������ (Data Race)
        // (������� 2 - ����������� ������ � ���� � ������� ��������� synchronized(this){}
        // (��� ����������� ������� synchronized(CustomThread.class){}),
        // ���������� �������� �������)---------------------------------------------------------------------------------

        Thread thread7 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                customThread.incrementCounter2();
            }
        });
        Thread thread8 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                customThread.incrementCounter2();
            }
        });
        thread7.start();
        thread8.start();
        thread7.join();
        thread8.join();

        // NB! �������� �1�: Data race ��������� ������ ����� �������� ������������ (Data Race)
        // (������� 3 - ������������� ������� ������� Lock)-------------------------------------------------------------

        Thread thread9 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                lock.lock();
                customThread.incrementCounter3();
                lock.unlock();
            }
        });
        Thread thread10 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                lock.lock();
                customThread.incrementCounter3();
                lock.unlock();
            }
        });
        thread9.start();
        thread10.start();
        thread9.join();
        thread10.join();

        // NB! �������� �2: ��������� ���� ����� ��������� ���������� �������
        // (������� - ������������� ���������� wait notify)-------------------------------------------------------------

        Thread thread11 = new Thread(() -> customThread.incrementCounter4());
        Thread thread12 = new Thread(() -> customThread.incrementCounter4());
        thread11.start();
        thread12.start();
        thread11.join();
        thread12.join();

        System.out.println(customThread.counter1);
        System.out.println(customThread.counter2);
        System.out.println(customThread.counter3.get());
        System.out.println(customThread.counter4);

        //  �������� ���� ������� (��� � 1 � ����������� ��������)------------------------------------------------------
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);

        Thread thread15 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        for(int i =0; i<10; i++ ){
            executorService2.execute(thread15);
        }
        executorService2.shutdown();

        Thread thread16 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        // �������� ������ ������� ������ ��������----------------------------------------------------------------------
        Future<Integer> customFuture = executorService1.submit(new CustomCallable());
        try {
            System.out.println(customFuture.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService1.shutdown();
        }

        // ����������� ����������� ������������ ���������� �������------------------------------------------------------

        ExecutorService executorService3 = Executors.newFixedThreadPool(5);
        Thread thread17 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                semaphore.release();
            }
        });
        for(int i =0; i<10; i++ ){
            executorService3.execute(thread17);
        }
        executorService3.shutdown();

        // ������ ���� ����� �� ������������ �������(��� ������� ������� ��)--------------------------------------------

        ExecutorService executorService4 = Executors.newFixedThreadPool(5);
        Thread thread18 = new Thread(() -> {

            while (countDownLatch.getCount() != 0){
                countDownLatch.countDown();
            }
        });
        thread18.start();
        thread18.join();

        Thread thread19 = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        for(int i =0; i<10; i++ ){
            executorService4.execute(thread19);
        }
        executorService4.shutdown();

        // �������� ����������� ����� ����� ��������--------------------------------------------------------------------
        Thread thread20 = new Thread(() -> {
            try {
                int result = exchanger.exchange(16);
                System.out.println(result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread thread21 = new Thread(() -> {
            try {
                int result = exchanger.exchange(25);
                System.out.println(result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread20.start();
        thread21.start();
        thread20.join();
        thread21.join();


        // ������������� ����������������� ��������---------------------------------------------------------------------
        // �������� � ������� synchronizedArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Integer> synchronizedArrayList = Collections.synchronizedList(arrayList);
        Thread thread22 = new Thread(() -> {
            synchronizedArrayList.add(51);
            synchronizedArrayList.add(52);
            synchronizedArrayList.add(53);
            synchronizedArrayList.add(54);
            synchronizedArrayList.add(55);
            synchronizedArrayList.add(56);
        });
        Thread thread23 = new Thread(() -> {
            synchronizedArrayList.add(41);
            synchronizedArrayList.add(41);
            synchronizedArrayList.add(43);
            synchronizedArrayList.add(44);
            synchronizedArrayList.add(45);
            synchronizedArrayList.add(46);
        });
        thread22.start();
        thread23.start();
        thread22.join();
        thread23.join();
        System.out.println(synchronizedArrayList);
        // �������� � ������ ������� ������� copyOnWriteArrayList
        CopyOnWriteArrayList<Integer>  copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Thread thread24 = new Thread(() -> {
            copyOnWriteArrayList.add(51);
            copyOnWriteArrayList.add(52);
            copyOnWriteArrayList.add(53);
            copyOnWriteArrayList.add(54);
            copyOnWriteArrayList.add(55);
            copyOnWriteArrayList.add(56);
        });
        Thread thread25 = new Thread(() -> {
            copyOnWriteArrayList.add(41);
            copyOnWriteArrayList.add(41);
            copyOnWriteArrayList.add(43);
            copyOnWriteArrayList.add(44);
            copyOnWriteArrayList.add(45);
            copyOnWriteArrayList.add(46);
        });
        thread24.start();
        thread25.start();
        thread24.join();
        thread25.join();
        System.out.println(copyOnWriteArrayList);

        // �������� � ������ ������� ������� ConcurrentHashMap
        ConcurrentHashMap<Integer, String > concurrentHashMap = new ConcurrentHashMap<>();

        Thread thread26 = new Thread(() -> {
            concurrentHashMap.put(51, "51");
            concurrentHashMap.put(52, "52");
            concurrentHashMap.put(53, "53");
            concurrentHashMap.put(54, "54");
            concurrentHashMap.put(55, "55");
            concurrentHashMap.put(56, "56");
        });
        Thread thread27 = new Thread(() -> {
            concurrentHashMap.put(41, "41");
            concurrentHashMap.put(42, "42");
            concurrentHashMap.put(43, "43");
            concurrentHashMap.put(44, "44");
            concurrentHashMap.put(45, "45");
            concurrentHashMap.put(46, "46");
        });
        thread26.start();
        thread27.start();
        thread26.join();
        thread27.join();
        for(Map.Entry<Integer, String> hash:concurrentHashMap.entrySet() ){
            System.out.print(hash.getValue() + ", ");
        }
        System.out.println();

        // �������� � ������ ������� ������� ArrayBlockingQueue (����������� �� ����������� ���������)
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);
        Thread thread28 = new Thread(() -> {
            int i = 0;
            while(i<10){
                try {
                    Thread.sleep(100);
                    arrayBlockingQueue.put(50 + i); // offer ���������� � �� ������ ��� � �������
                    i++;
                    System.out.println("IN:" + arrayBlockingQueue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        Thread thread29 = new Thread(() -> {
            int i = 10;
            while(i>0){
                try {
                    Thread.sleep(300);
                    arrayBlockingQueue.take();
                    i--;
                    System.out.println("OUT:" +arrayBlockingQueue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread28.start();
        thread29.start();
        thread28.join();
        thread29.join();


        // ���������� ������ interrupt----------------------------------------------------------------------------------
        Thread thread13 = new Thread(() -> {
            while(!thread1.isInterrupted()){
                System.out.println("thread13");
            }
        });
        thread13.start();

        //  �������� ������ (������� ������, + �������� ��������� �������� �������) ��� �������������� ���� ������------
        Thread thread14 = new Thread(() -> {
            while(true){
                System.out.println("����� 14 ��������");
            }
        });

        thread14.setDaemon(true);
        thread14.start();
        thread1.interrupt();

        System.out.println("����� Main �������� ������");
    }
}

class FirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello it's thread1");
    }
}

class SecondThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello it's thread2");
    }
}

class CustomCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 256;
    }
}

