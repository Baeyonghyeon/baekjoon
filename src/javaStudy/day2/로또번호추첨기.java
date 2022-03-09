package javaStudy.day2;

import java.util.Arrays;
import java.util.Random;

public class 로또번호추첨기 {
    static int lotto[];

    public static void main(String[] args) {
        lotto = new int[6];

        lottoGenerate();
        System.out.println(Arrays.toString(lotto));
    }

    private static void lottoGenerate() {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            lotto[i] = random.nextInt(45) + 1; // 1 ~ 45
        }

        bubbleSort();
    }

    private static void bubbleSort() {
        for (int i = 1; i < lotto.length; i++) {
            for (int j = 0; j < lotto.length - 1; j++) {
                if (lotto[j] > lotto[j + 1]) {
                    int tmp = lotto[j];
                    lotto[j] = lotto[j + 1];
                    lotto[j + 1] = tmp;
                }
            }
        }

        reduplication();
    }

    //중복검사
    private static void reduplication() {
        for (int i = 0; i < lotto.length; i++) {
            if(i == lotto.length-1) break;
            else if(lotto[i] == lotto[i+1]){
                lottoGenerate();
                break;
            }
        }
    }
}
