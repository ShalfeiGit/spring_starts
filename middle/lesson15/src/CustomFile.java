import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;

public class CustomFile {
    public static void main(String[] args) throws IOException {
        String text1 = "��������� ������ 1\n";
        String text2 = "��������� ������ 2\n";
        String text3 = "��������� ������ 3\n";
        String text4 = "��������� ������ 4\n";
        try (
                FileWriter fileWriter = new FileWriter("test1.txt"); // (������ � �������)
                FileReader fileReader = new FileReader("test1.txt");
                BufferedReader bufferedReader = new BufferedReader(new FileReader("test2.txt")); // ��� �� ����� �� � ������ (������ � �������)
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test2.txt"));
                FileInputStream fileInputStream = new FileInputStream("pic1.jpg");  // ��� �� ����� (������ � ��������� �������)
                FileOutputStream fileOutputStream = new FileOutputStream("test\\pic1.jpg");
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("test3.bin")); // ��� �� ����� (������ � ��������� ������� + ������ � ������������ ������ ������)
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("test3.bin"));
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test4.bin"));// ��� �� ����� (������ � ��������� ������� + ������ � ���������� ������ ������)
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test4.bin"));
                RandomAccessFile randomAccessFile = new RandomAccessFile("test5.txt", "rw");// ������ � ������� � ������������ �������
                RandomAccessFile randomAccessFileForChannel = new RandomAccessFile("text7.txt", "rw");// ������ � ������� � ������������ �������
        ) { // try with resources, �� ���� �  finally �������� fileReader.close()

            for (int i = 0; i < text1.length(); i++) {
                fileWriter.write(text1.toCharArray()[i]); // ������ �� ��������� 1
            }

            for (int i = 0; i < text1.length(); i++) {
                fileWriter.write(text2.charAt(i)); // ������ �� ��������� 2
            }
            fileWriter.write(text3); // ����c� �������
            fileWriter.close(); // ��������� ������ � ������

            bufferedWriter.write(text4); // ������ ������� 1 c ������
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
            while ((character = fileReader.read()) != -1) { // ���������� �� ���������
                System.out.print((char) character);
            }
            int symbol;
            while ((symbol = fileInputStream.read()) != -1) { // ���������� �� ���������
                fileOutputStream.write(symbol);
            }

            String line;
            while ((line = bufferedReader.readLine()) != null) { // ���������� �������
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