package java.javastudy.day11;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class IOExample {
    public static void main(String[] args) {
        IOExample ex = new IOExample();
        ex.piped();
    }

    private void piped() {
        try (PipedInputStream pipedInputStream = new PipedInputStream();
             PipedOutputStream pipedOutputStream = new PipedOutputStream()) {

            pipedInputStream.connect(pipedOutputStream);    // !

            Thread pipeWriter = new Thread(() -> {
                for (int i = 65; i < 91; i++) {
                    try {
                        pipedOutputStream.write(i);
                        Thread.sleep(500);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            /*Thread for reading data from pipe*/
            Thread pipeReader = new Thread(() -> {
                for (int i = 65; i < 91; i++) {
                    try {
                        System.out.print((char) pipedInputStream.read());
                        Thread.sleep(500);
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            pipeWriter.start();
            pipeReader.start();

            // wait thread
            pipeWriter.join();
            pipeReader.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
