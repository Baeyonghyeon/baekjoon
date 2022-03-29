package javastudy.day11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FileExample {
    public static void main(String[] args) throws IOException {
        FileExample e = new FileExample();
        e.write();
//        e.read();
//        e.access();
        e.randomAccess();
    }

    private void randomAccess() {
        try (RandomAccessFile file = new RandomAccessFile("myfile.txt", "rw")) {

            file.writeChar('S');                // 2
            file.writeInt(2222);                // 4
            file.writeDouble(222.22);           // 8
            file.writeInt(32243);               // 4
            file.writeBoolean(false);           // 1 byte
            System.out.println(file.length());

            file.seek(0);                     // 처음으로 이동
            System.out.println(file.readChar());
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            file.seek(2);
            System.out.println(file.readInt());
            file.seek(14);
            System.out.println(file.readInt());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void access() throws IOException {
        File f = new File("/Users/a000/IdeaProjects/beakjoon/src/javaStudy/day11/fileExampleText");
        System.out.println("name: " + f.getName());
        System.out.println("path: " + f.getPath());
        System.out.println("absolute path: " + f.getAbsolutePath());
        System.out.println("canonical path: " + f.getCanonicalPath());
        System.out.println("parent: " + f.getParent());
        System.out.println("separator: " + File.separator);
    }

    private void read() {
        Path filePath = Paths.get("/Users/a000/IdeaProjects/beakjoon/src/javaStudy/day11/fileExampleText");
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write() throws IOException {
        Path path = Paths.get("/Users/a000/IdeaProjects/beakjoon/src/javaStudy/day11/");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.write("Hello World !!");
            writer.write(System.lineSeparator());
        }
    }
}
