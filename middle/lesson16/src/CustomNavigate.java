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
        System.out.println(file1_1.getAbsolutePath()); // получение полного пути до папки/файла
        System.out.println(folder1_1.getAbsolutePath());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.isAbsolute()); // проврка полный ли путь
        System.out.println(folder1_1.isAbsolute());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.isDirectory()); // проврка директория ли это
        System.out.println(folder1_1.isDirectory());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.exists()); // проврка существует ли файл/директория ли это
        System.out.println(folder1_1.exists());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.exists()); // проврка существует ли файл/директория ли это
        System.out.println(folder1_1.exists());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.createNewFile()); // Если таких файлов/директорий нет то создаст возвращает true(создан) false(не создан)
        System.out.println(folder1_1.mkdir());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_2.delete()); // Удалим файл/папку папки или файла
        //--------------------------------------------------------------------------------------------------------------
        File[] files = folder2.listFiles(); // список всех путей внутри папки
        System.out.println(Arrays.toString(files));
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file1_1.isHidden());
        System.out.println(file1_1.canRead());
        System.out.println(file1_1.canWrite());
        System.out.println(file1_1.canExecute());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.getFileName()); //имя папки/файла но с paths
        System.out.println(folder2_1.getFileName());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.getParent()); //имя родительской папки/файла но с paths
        System.out.println(folder2_1.getParent());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.isAbsolute()); //абсолютный ли путь до папки/файла
        System.out.println(folder2_1.isAbsolute());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(file2_1.toAbsolutePath()); //абсолютный путь до папки/файла
        System.out.println(folder2_1.toAbsolutePath());
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(folder2_1.resolve(file2_1.getFileName())); //складывает пути от папки до файла
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(folder3_2.relativize(folder3_1)); //путь отностильно друго пути от папки до файла

        if(!Files.exists(file4_1)){
            Files.createFile(file4_1);
        }
        System.out.println(Files.isReadable(file4_1));
        System.out.println(Files.isWritable(file4_1));
        System.out.println(Files.isExecutable(file4_1));
        System.out.println(Files.isSameFile(file4_2, file4_1)); // проверка на тот же ли самый файл
        System.out.println(Files.size(file4_2)); // размер файл
        System.out.println(Files.getAttribute(file4_2,"creationTime")); // выбрать один аттрибут для файла

        Map<String, Object> attrs = Files.readAttributes(file4_2,"*");
        for(Map.Entry<String, Object> attr: attrs.entrySet()){
            System.out.println(attr); // выбрать все аттрибуты для файла
        }

        Files.copy(file5_2, folder5_1.resolve(file5_2), StandardCopyOption.REPLACE_EXISTING); // копирование файла
        Files.move(file5_4, folder5_3.resolve(file5_4), StandardCopyOption.ATOMIC_MOVE); // перемещение файла
        Files.delete(folder5_3.resolve(file5_4)); //удаление файла
        Files.createFile(file5_4);// создание файла
        String testString = "Hello, my name is Valentine, А меня Петя";

        Files.write(file5_4, testString.getBytes(StandardCharsets.UTF_8));// запись в файл
        List<String> list = Files.readAllLines(file5_4); // чтение всех строк
        for(String l:list){
            System.out.println(l);
        }
        //--------------------------------------------------------------------------------------------------------------
        Files.walkFileTree(src, new MyFileVisitor()); //для обхода по дереву файлов
    }
}

class MyFileVisitor implements FileVisitor<Path> { //файл с действиями которые происходят до или после обхода дерефа папок и файлов см название методов
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
