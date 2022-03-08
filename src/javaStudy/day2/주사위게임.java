package javaStudy.day2;

import java.util.Random;
import java.util.Scanner;

public class 주사위게임 {
    static int n;           //참가자 수
    static int diceCount;   //주사위 개수
    static int score[][];   //스코어 기록
    static int Winner[];

    public static void main(String[] args) {
        init();
        rollTheDice();
        totalScore();
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);

        System.out.print("참가자를 지정해 주세요: ");
        n = sc.nextInt();
        System.out.println("주사위 개수를 지정해 주세요: ");
        diceCount = sc.nextInt();

        //주사위 값들을 저장하고 score[n][diceCount+1]에는 총합 저장
        score = new int[n][diceCount+1];
    }

    private static void rollTheDice(){
        for(int i=0; i<n;i++){
           roll(i);
        }
    }

    private static void roll(int user){
        for(int j=0; j<diceCount; j++){
            Random random = new Random();
            int diceScale = random.nextInt(6) + 1; //1 ~ 6;
            score[user][j] += diceScale;
        }

        check(user);
    }

    // 숫자가 같은지 확인
    private static void check(int user){
        int compare = score[user][0];
        for(int i=1; i<diceCount; i++){
            if(compare != score[user][i]) return;
        }

        roll(user);
    }

    //최종점수 계산
    private static void totalScore(){
        int max = 0;

        for(int i=0; i<n; i++){
            int total = 0;
            for(int j=0; j<diceCount; j++){
                total += score[i][j];
            }

            score[i][diceCount+1] = total;

            if(max < total){
                max = total;
            }
        }
    }
}
