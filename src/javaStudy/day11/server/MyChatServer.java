package javaStudy.day11.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

public class MyChatServer {
    // clientId: 클라이언트 전송(출력)용 OutputStream (공유자원, ConcurrentHashMap 자료구조 성능과 동기화 처리가능한 자료구조임)
    // 이것을
    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap();

    public static void main(String[] args) throws IOException {
        MyChatServer server = new MyChatServer();
        server.start();
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    ClientSession client = new ClientSession(socket);
                    client.start();
                } catch (IOException e) {
                    // TODO 클라이언트 접속 실패
                }
            }
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    //접속 정보 추가
    private void joinChat(ClientSession session) {
        clientOutMap.put(session.id, session.out);

        sendToAll("[System] " + session.id + "님이 입장했습니다.");
        System.out.println(getTime() + " " + session.id + " is joined: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void leaveChat(ClientSession session) {
        clientOutMap.remove(session.id);

        sendToAll("[System] " + session.id + "님이 나갔습니다.");
        System.out.println(getTime() + " " + session.id + " is leaved: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    //현재 클라이언트 접속자수
    private void loggingCurrentClientCount() {
        System.out.println(getTime() + " Currently " + clientOutMap.size() + " clients are connected.");
    }

    //모든 사람들에게 메시지를 전달
    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }

    //개인 메시지 전달
    private void sendToUser(ClientSession session, String message) {
        if (clientOutMap.containsKey(session.id)) {
            try {
                clientOutMap.get(session.id).writeUTF(message);
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }

    //개인 메시지 전달
    private void sendToUser(ClientSession session, StringBuilder message) {
        if (clientOutMap.containsKey(session.id)) {
            try {
                clientOutMap.get(session.id).writeUTF(String.valueOf(message));
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }

    class ClientSession extends Thread {

        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;
        private String id;
        private User user;
        private GameConsole gameConsole;
        private Battlefield battlefield;

        ClientSession(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            initialize();
            connectSelectNumber();
            
            selectTryConsole();     //첫번째 전투(슬라임)
            selectTryConsole();     //승리시 2번째 전투(오크)
            selectTryConsole();     //승리시 3번째 전투(드래곤)
            connectSendToAll();     //드래곤 클리어
        }

        private void initialize() {
            try {
                this.id = in.readUTF(); //클라이언트에서 아이디를 바로 보내줌
                this.user = new User(this.id);
                this.gameConsole = new GameConsole(this.user);

                joinChat(this);
                sendToUser(this, gameConsole.gameStartConsole());       //시작 콘솔 드래곤을
                sendToUser(this, gameConsole.gameMainConsole());       //게임 입장 콘솔 또 옮긴거임
            } catch (IOException cause) {
                // TODO: 최초 통신(아이디 받기)이 실패하는 경우
            }
        }

        private void connectSelectNumber() {
            try {
                if (isConnect()) {
                    int select = Integer.parseInt(in.readUTF());
                    dungeonProgress(select);
                }
            } catch (IOException cause) {
                // TODO: 채팅 중 연결이 끊기는 경우
            }
        }

        private void connectSendToAll() {
            try {
                if (isConnect()) {
                    sendToAll("[외침] 용사 "+id+"가 드래곤을 물리쳤다!.");          //전체 방송
                }
            } finally {
                disconnect();
            }
        }

        private StringBuilder getCurrentStatus() {
            return user.getCurrentStatus();
        }   //현재 유저 스탯

        private boolean isConnect() {
            return this.in != null;
        }

        private void disconnect() {
            leaveChat(this);
        }

        private void dungeonProgress(int num) {
            if (num == 2) {
                sendToUser(this, "게임을 종료합니다.");
                disconnect();
            }
        }

        private void selectTryConsole() {
            try {
                if (isConnect()) {
                    sendToUser(this,gameConsole.selectTryConsole());
                    int select = Integer.parseInt(in.readUTF());
                    if (select == 1) {
                        battlefield = new Battlefield(this.user);
                        sendToUser(this, battlefield.fight());
                        //전투가 끝날때마다 용사 스탯을 보여줌
                        sendToUser(this, getCurrentStatus());

                    } else {
                        sendToUser(this, "게임을 종료합니다.");
                        disconnect();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
