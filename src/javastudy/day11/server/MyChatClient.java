package javastudy.day11.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class MyChatClient {
    private final String id;

    public MyChatClient(String id) {
        this.id = id;
    }

    public static void main(String[] args) throws UnknownHostException {
        if (hasNotArgs(args)) {
            System.out.println("USAGE: java MyChatClient {id}");
            return;
        }
        String id = args[0];
        MyChatClient client = new MyChatClient(id);
        client.connect("127.0.0.1", 8888);
    }

    private static boolean hasNotArgs(String[] args) {
        return args.length == 0;
    }

    private void connect(String serverHost, int port) throws UnknownHostException {
        try {
            Socket socket = new Socket(serverHost, port);
            System.out.println("Connected to server " + serverHost + ":" + port);
            Thread sender = new Sender(socket, id); // 메시지 보내는 스레드
            Thread receiver = new Receiver(socket); // 받는 스레드

            sender.start();
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Sender extends Thread {
        private String id;
        private DataOutputStream out;

        private Sender(Socket socket, String id) throws IOException {
            this.id = id;
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
                initialize();
                sendMessage();
            } catch (IOException e) {
                System.out.println("에러");
            }
        }

        private void initialize() throws IOException {
            //아이디를 서버에 보내면서 시작
            if (isSendable()) {
                this.out.writeUTF(id);
            }
        }

        private boolean isSendable() {
            return this.out != null;
        }

        private void sendMessage() throws IOException {
            try (Scanner scanner = new Scanner(System.in)) {
                while (isSendable()) {
                    this.out.writeUTF(scanner.nextLine());
                }
            }
        }
    }

    private static class Receiver extends Thread {
        private final DataInputStream in;

        private Receiver(Socket socket) throws IOException {
            this.in = new DataInputStream(socket.getInputStream());
        }

        @Override
        public void run() {
            while (isReceivable()) {
                receiveMessage();
            }
        }

        private boolean isReceivable() {
            return this.in != null;
        }

        private void receiveMessage() {
            try {
                System.out.println(in.readUTF());
            } catch (IOException e) {
                System.out.println("에");
            }
        }
    }
}
