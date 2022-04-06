package java.javastudy.day11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class downloadZip {
    public static void main(String[] args) throws MalformedURLException {
        downloadZip dz = new downloadZip();
        dz.test();
    }

    private void test() throws MalformedURLException {
        URL url = new URL("https://nhn.com/ci/NHN_CI.zip");
        try (BufferedInputStream input = new BufferedInputStream(url.openStream());
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("/Users/a000/IdeaProjects/beakjoon/nhnci.zip"))) {
            byte[] buf = new byte[1024];
            int byteSize = 0;
            while ((byteSize = input.read(buf)) > -1) {
                output.write(buf, 0, byteSize);
            }
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}