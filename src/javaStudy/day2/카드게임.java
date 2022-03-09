package javaStudy.day2;

import java.util.Arrays;
import java.util.Random;

public class 카드게임 {
    static String deck[][];                 //트럼프 카드 덱
    static String list[];                   //뽑은 카드를 보관(중복검사 & 점수 합계 계산)
    static int[] score;
    static int cnt;                         //카드 몇 장 뽑았는지 카운팅
    static boolean bl;

    public static void main(String[] args) {

        while (!bl) {
            init();
            //유저 턴
            cardChoice();
            cardChoice();
            //컴퓨터 턴
            cardChoice();
            cardChoice();

            gamePrint();
            call();
        }

    }

    private static void call() {
        for (int i = 0; i < 4; i++) {
            String token[] = list[i].split(" ");

            if (token.length == 2) {
                int sc;

                if (token[1].equals("A")) sc = 1;
                else if (token[1].equals("J")) sc = 11;
                else if (token[1].equals("Q")) sc = 12;
                else if (token[1].equals("K")) sc = 13;
                else sc = Integer.parseInt(token[1]);

                score[i] = sc;
            } else {  //조커 일때
                score[i] = 100;
            }
        }

        if (((score[0] + score[1] > 100) && (score[2] + score[3] > 100)) ||
                (score[0] + score[1] == score[2] + score[3])) {
            System.out.println("무승부 입니다 게임을 재시작합니다.");

        } else {
            if ((score[0] + score[1]) > (score[2] + score[3])) {
                System.out.println("유저가 이겼습니다");
            } else {
                System.out.println("컴퓨터가 이겼습니다.");
            }

            bl = true;
        }
    }

    private static void cardChoice() {
        Random random = new Random();
        int x = random.nextInt(5); // 0 ~ 4
        int y = random.nextInt(13); // 0 ~ 13

        if (deck[x][y] == null) {
            cardChoice();
            return;
        } else {
            if (Arrays.asList(list).contains(deck[x][y])) {
                cardChoice();
                return;
            } else {
                list[cnt++] = deck[x][y];
            }
        }


    }

    private static void gamePrint() {
        System.out.print("유저가 뽑은 카드 : ");
        System.out.println(list[0] + " " + list[1]);
        System.out.print("컴퓨터가 뽑은 카드 : ");
        System.out.println(list[2] + " " + list[3]);
    }

    private static void init() {
        deck = new String[5][13];
        list = new String[4];
        score = new int[4];
        cnt = 0;

        cardSet();
    }

    private static void cardSet() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[i][j] = suit(i) + number(j);
            }
        }
        deck[4][0] = "JOKER1";
        deck[4][1] = "JOKER2";
    }

    private static String suit(int num) {
        if (num == 0) return "하트 ";
        else if (num == 1) return "스페이드 ";
        else if (num == 2) return "클로버 ";
        else return "다이아몬드 ";
    }

    private static String number(int num) {
        if (num == 0) return "A";
        else if (num == 10) return "J";
        else if (num == 11) return "Q";
        else if (num == 12) return "K";
        else return String.valueOf(num + 1);
    }
}
