package java.javastudy.day2;

import java.util.Random;
import java.util.Scanner;

public class 주사위게임 {
    static int n;               //참가자 수
    static int diceQuantity;    //주사위 개수
    static int score[][];       //스코어 기록
    static boolean Winner[];    //우승자

    public static void main(String[] args) {
        init();
        rollTheDice();
        totalScore();
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);

        System.out.print("참가자를 지정해 주세요: ");
        n = sc.nextInt();
        System.out.print("주사위 개수를 지정해 주세요: ");
        diceQuantity = sc.nextInt();

        //주사위 값들을 저장하고 score[n][diceCount]에는 total 저장
        score = new int[n][diceQuantity+1];
        Winner = new boolean[n];

        sc.close();
    }

    private static void rollTheDice(){
        for(int i=0; i<n;i++){
           roll(i);
        }
    }

    private static void roll(int user){
        Random random = new Random();

        for(int j=0; j<diceQuantity; j++){
            int diceScale = random.nextInt(6) + 1; //1 ~ 6;
            score[user][j] += diceScale;
        }

        check(user);
    }

    // 숫자가 같은지 확인
    private static void check(int user){
        int compare = score[user][0];
        for(int i=1; i<diceQuantity; i++){
            if(compare != score[user][i]) return;
        }

        roll(user);
    }

    //최종점수 계산 & 최대값 구하기
    private static void totalScore(){
        int max = 0;

        for(int i=0; i<n; i++){
            int total = 0;
            for(int j=0; j<diceQuantity; j++){
                total += score[i][j];
            }

            score[i][diceQuantity] = total;

            if(max < total){
                max = total;
            }
        }

        winner(max);
    }

    private static void winner(int max){
        int cnt = 0;    //최고점 인원수
        for(int i=0; i<n; i++){
            if(score[i][diceQuantity] == max) {
                Winner[i] = true;
                cnt++;
            }
        }

        if(cnt == 1){
            System.out.print("우승자는 : ");
            for(int i=0; i<n; i++){
                if(Winner[i]) System.out.print(i+"번 입니다.");
            }
        }else{
            System.out.print("공동 우승자 : ");
            for(int i=0; i<n; i++){
                if(Winner[i]) System.out.print(i+", ");
            }
            System.out.println("입니다.");
        }
    }
}
