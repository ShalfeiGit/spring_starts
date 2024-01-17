import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;

public class CustomFile {
    public static void main(String[] args) throws IOException {
        String text1 = "Текстовая строка 1\n";
        String text2 = "Текстовая строка 2\n";
        String text3 = "Текстовая строка 3\n";
        String text4 = "Текстовая строка 4\n";
        try (
                FileWriter fileWriter = new FileWriter("test1.txt"); // (работа с текстом)
                FileReader fileReader = new FileReader("test1.txt");
                BufferedReader bufferedReader = new BufferedReader(new FileReader("test2.txt")); // тот же стрим но с буфром (работа с текстом)
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test2.txt"));
                FileInputStream fileInputStream = new FileInputStream("pic1.jpg");  // тот же стрим (работа с бинарными файлама)
                FileOutputStream fileOutputStream = new FileOutputStream("test\\pic1.jpg");
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("test3.bin")); // тот же стрим (работа с бинарными файлама + работа с примитивными типами данных)
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("test3.bin"));
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test4.bin"));// тот же стрим (работа с бинарными файлама + работа с ссылочными типами данных)
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test4.bin"));
                RandomAccessFile randomAccessFile = new RandomAccessFile("test5.txt", "rw");// работы с текстом с произвольной позиции
                RandomAccessFile randomAccessFileForChannel = new RandomAccessFile("text7.txt", "rw");// работы с текстом с произвольной позиции
        ) { // try with resources, не надо в  finally вызывать fileReader.close()

            for (int i = 0; i < text1.length(); i++) {
                fileWriter.write(text1.toCharArray()[i]); // запись по символьно 1
            }

            for (int i = 0; i < text1.length(); i++) {
                fileWriter.write(text2.charAt(i)); // запись по символьно 2
            }
            fileWriter.write(text3); // запиcь строкой
            fileWriter.close(); // завершить работу с файлом

            bufferedWriter.write(text4); // запись строкой 1 c буфром
            bufferedWriter.close();

            dataOutputStream.writeInt(10);
            dataOutputStream.close();

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Hello");
            arrayList.add("Buy");

            Test5 test5 = new Test5("Vova");

            objectOutputStream.writeObject(arrayList);
            objectOutputStream.writeObject(test5);
            objectOutputStream.close();

            randomAccessFile.seek( 5);
            randomAccessFile.writeBytes("Hi");
            randomAccessFile.seek( 0);
            System.out.println(randomAccessFile.readLine());
            randomAccessFile.close();

            String text8 = "New text string for working with channel and buffer";
            ByteBuffer buffer2 = ByteBuffer.allocate(text8.getBytes().length);
            buffer2.put(text8.getBytes());
            buffer2.flip();
            FileChannel channel1 = randomAccessFileForChannel.getChannel();
            channel1.write(buffer2);
            //----------------------------------------------------------------------------------------------------------

            int character;
            while ((character = fileReader.read()) != -1) { // считывание по символьно
                System.out.print((char) character);
            }
            int symbol;
            while ((symbol = fileInputStream.read()) != -1) { // считывание по символьно
                fileOutputStream.write(symbol);
            }

            String line;
            while ((line = bufferedReader.readLine()) != null) { // считывание строкой
                System.out.println(line);
            }

            System.out.println(dataInputStream.readInt());
            System.out.println(objectInputStream.readObject());
            System.out.println(objectInputStream.readObject());
            randomAccessFileForChannel.seek(0);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int byteRead = channel1.read(buffer);
            StringBuilder stringBuilder = new StringBuilder();
            while(byteRead>0){
                System.out.println(byteRead);
                buffer.flip();

                while(buffer.hasRemaining()){
                    stringBuilder.append((char) buffer.get());
                }
                buffer.clear();
                byteRead=channel1.read(buffer);
            }
            System.out.println(stringBuilder);

            //----------------------------------------------------------------------------------------------------------
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Test5 implements Serializable {
    String name;

    public Test5(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test5{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test5 test5 = (Test5) o;
        return Objects.equals(name, test5.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}