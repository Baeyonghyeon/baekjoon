package javastudy.day2;

import java.util.Random;
import java.util.Scanner;

public class Random스무고개실습 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        Random random = new Random();
        int result = random.nextInt(20) + 1; //1 ~ 20;

        do {
            num = sc.nextInt();
            if (num < result){
                System.out.println("더 큰 값이에요.");
            }else if(num > result){
                System.out.println("더 작은 값이에요");
            }else {
                System.out.printf("%d 정답입니다.", num);
            }
        } while (num != result);
    }

}
