package java.javastudy.day2;

import java.util.Random;

public class 배열10이하숫자찾기 {
    static int count;

    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();
        for(int i=0; i<numbers.length;i++){
            numbers[i] = random.nextInt(20)+1;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] < 11) count++;
        }

        System.out.println(count);
    }
}
