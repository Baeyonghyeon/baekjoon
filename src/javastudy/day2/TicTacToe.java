package javastudy.day2;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static int putCount;

    static char[][] board = new char[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }

        while (true){
            //사용자 턴
            System.out.print("사용자 턴(x y): ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = 'o';

            boardWrite();
            if(call()){
                System.out.println("유저가 승리했습니다.");
                break;
            }

            //컴퓨터턴
            System.out.println("컴퓨터 턴");
            while (true){
                x = random.nextInt(3); //0 ~ 2;
                y = random.nextInt(3); //0 ~ 2;

                if(board[x][y] ==' '){
                    board[x][y] = 'x';
                    break;
                }
            }

            boardWrite();
            if(call()){
                System.out.println("컴퓨터가 승리했습니다.");
                break;
            }

            putCount++;
            if(putCount == 9){
                System.out.println("무승부 입니다.");
            }
        }

    }

    //보드 그리기
    private static void boardWrite(){
        for(int i=0; i<3; i++){
            System.out.println(" "+ board[i][0] + "|"+ board[i][1]+ "|" + board[i][2]);
            if(i != 2){
                System.out.println("--|--|--");
            }
        }
    }

    //심판
    private static boolean call(){
        int cnt = 0;
        char ch;
        //가로검사
        for(int i=0; i<3; i++){
            ch = board[i][0];
            if(ch != ' '){
                for(int j=1; j<3; j++){
                    if(ch == board[i][j]) cnt++;
                    else break;
                }
            }

            if(cnt == 2) return true;
            cnt = 0;
        }

        //세로검사
        for(int i=0; i<3; i++){
            ch = board[0][i];
            if(ch != ' '){
                for(int j=1; j<3; j++){
                    if(ch == board[j][i]) cnt++;
                    else break;
                }
            }

            if(cnt == 2) return true;
            cnt = 0;
        }

        //대각선 검사
        if(board[0][0] != ' '){
            ch = board[0][0];
            if (ch == board[1][1] && ch == board[2][2]) return true;
        }

        if(board[0][2] != ' '){
            ch = board[0][2];
            if (ch == board[1][1] && ch == board[2][0]) return true;
        }

        return false;
    }
}
