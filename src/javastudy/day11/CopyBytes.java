package javastudy.day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("/Users/a000/IdeaProjects/beakjoon/src/javaStudy/day11/source.txt");
        FileOutputStream out = new FileOutputStream("replica.txt")){
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}