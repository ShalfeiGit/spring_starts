import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CustomNavigate {
    public static void main(String[] args) throws IOException {
        File file1_1 = new File("src\\test\\first\\test1.1.txt");
        File folder1_1 = new File("src\\test\\first\\test1.1.txt");
        File folder2 = new File("src\\test2");
        File file1_2 = new File("src\\test\\second\\test1.2.txt");

        Path src = Paths.get("src");
        Path file2_1 = Paths.get("src\\test2\\second\\test2.2.1.txt");
        Path folder2_1 = Paths.get("src\\test2\\second");
        Path folder3_1 = Paths.get("src\\test2\\third\\one\\two\\we.txt");
        Path folder3_2 = Paths.get("src\\test2\\third");
        Path file4_1 = Paths.get("src\\test\\second\\test1.2.6.txt");
        Path file4_2 = Paths.get("src\\test\\second\\test1.2.6.txt");
        Path folder5_1 = Paths.get("src\\test\\second\\M\\N");
        Path folder5_3 = Paths.get("src\\test\\second\\B");
        Path file5_2 = Paths.get("test1.2.76.txt");
        Path file5_4 = Paths.get("test1.2.77.txt");

        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.getAbsolutePath()); // ��������� ������� ���� �� �����/�����
        System.out.println(folder1_1.getAbsolutePath());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.isAbsolute()); // ������� ������ �� ����
        System.out.println(folder1_1.isAbsolute());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.isDirectory()); // ������� ���������� �� ���
        System.out.println(folder1_1.isDirectory());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.exists()); // ������� ���������� �� ����/���������� �� ���
        System.out.println(folder1_1.exists());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.exists()); // ������� ���������� �� ����/���������� �� ���
        System.out.println(folder1_1.exists());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.createNewFile()); // ���� ����� ������/���������� ��� �� ������� ���������� true(������) false(�� ������)
        System.out.println(folder1_1.mkdir());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_2.delete()); // ������ ����/����� ����� ��� �����
        //--------------------------------------------------------------------------------------------------------------
        File[] files = folder2.listFiles(); // ������ ���� ����� ������ �����
        System.out.println(Arrays.toString(files));
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.isHidden());
        System.out.println(file1_1.canRead());
        System.out.println(file1_1.canWrite());
        System.out.println(file1_1.canExecute());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.getFileName()); //��� �����/����� �� � paths
        System.out.println(folder2_1.getFileName());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.getParent()); //��� ������������ �����/����� �� � paths
        System.out.println(folder2_1.getParent());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.isAbsolute()); //���������� �� ���� �� �����/�����
        System.out.println(folder2_1.isAbsolute());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.toAbsolutePath()); //���������� ���� �� �����/�����
        System.out.println(folder2_1.toAbsolutePath());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(folder2_1.resolve(file2_1.getFileName())); //���������� ���� �� ����� �� �����
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(folder3_2.relativize(folder3_1)); //���� ����������� ����� ���� �� ����� �� �����

        if(!Files.exists(file4_1)){
            Files.createFile(file4_1);
        }
        System.out.println(Files.isReadable(file4_1));
        System.out.println(Files.isWritable(file4_1));
        System.out.println(Files.isExecutable(file4_1));
        System.out.println(Files.isSameFile(file4_2, file4_1)); // �������� �� ��� �� �� ����� ����
        System.out.println(Files.size(file4_2)); // ������ ����
        System.out.println(Files.getAttribute(file4_2,"creationTime")); // ������� ���� �������� ��� �����

        Map<String, Object> attrs = Files.readAttributes(file4_2,"*");
        for(Map.Entry<String, Object> attr: attrs.entrySet()){
            System.out.println(attr); // ������� ��� ��������� ��� �����
        }

        Files.copy(file5_2, folder5_1.resolve(file5_2), StandardCopyOption.REPLACE_EXISTING); // ����������� �����
        Files.move(file5_4, folder5_3.resolve(file5_4), StandardCopyOption.ATOMIC_MOVE); // ����������� �����
        Files.delete(folder5_3.resolve(file5_4)); //�������� �����
        Files.createFile(file5_4);// �������� �����
        String testString = "Hello, my name is Valentine, � ���� ����";

        Files.write(file5_4, testString.getBytes(StandardCharsets.UTF_8));// ������ � ����
        List<String> list = Files.readAllLines(file5_4); // ������ ���� �����
        for(String l:list){
            System.out.println(l);
        }
        //--------------------------------------------------------------------------------------------------------------
        Files.walkFileTree(src, new MyFileVisitor()); //��� ������ �� ������ ������
    }
}

class MyFileVisitor implements FileVisitor<Path> { //���� � ���������� ������� ���������� �� ��� ����� ������ ������ ����� � ������ �� �������� �������
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
