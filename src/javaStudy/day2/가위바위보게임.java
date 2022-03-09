package javaStudy.day2;

import java.util.Random;
import java.util.Scanner;

public class 가위바위보게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("가위(1) 바위(2) 보(3): ");
            int user = sc.nextInt();
            int com = random.nextInt(3) + 1; //1 ~ 3;

            System.out.println("당신은 " + hand(user));
            System.out.println("컴퓨터는 " + hand(com));

            if(user == 1){
                if(com == 2) {
                    System.out.println("졌습니다.");
                    break;
                }else if (com == 3){
                    System.out.println("이겼습니다.");
                    break;
                }else{
                    System.out.println("비겼습니다. 다시 합니다.");
                }
            }else if (user == 2){
                if(com == 3) {
                    System.out.println("졌습니다.");
                    break;
                }else if (com == 1){
                    System.out.println("이겼습니다.");
                    break;
                }else{
                    System.out.println("비겼습니다. 다시 합니다.");
                }
            }else{ //user == 3
                if(com == 1) {
                    System.out.println("졌습니다.");
                    break;
                }else if (com == 2){
                    System.out.println("이겼습니다.");
                    break;
                }else{
                    System.out.println("비겼습니다. 다시 합니다.");
                }
            }
        }
    }

    private static String hand(int num) {
        String str;
        if (num == 1) str = "가위(1)입니다.";
        else if (num == 2) str = "바위(2)입니다.";
        else str = "보(3)입니다.";

        return str;
    }
}
