package javaStudy.day2;

import java.security.SecureRandom;
import java.util.*;

public class 로또번호추첨기 {
    //static int lotto[];
    static List<Integer> lotto;
    static boolean bl;
    public static void main(String[] args) {
        //lotto = new int[6];

        while (!bl) {
            lotto = new ArrayList<>();
            lottoGenerate();    //로또 생성
            bubbleSort();       //버블 정렬
            bl = reduplication();    //중복 검사
        }

        System.out.println(lotto.toString());
    }

    private static void lottoGenerate() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            //lotto[i] = random.nextInt(45) + 1; // 1 ~ 45
            lotto.add(random.nextInt(45) + 1);  // 1 ~ 45
        }
    }

    private static void bubbleSort() {
        for (int i = 1; i < lotto.size()/*lotto.length*/; i++) {
            for (int j = 0; j < lotto.size() - 1/*lotto.length - 1*/; j++) {
//                if (lotto[j] > lotto[j + 1]) {
//                    int tmp = lotto[j];
//                    lotto[j] = lotto[j + 1];
//                    lotto[j + 1] = tmp;
//                }

                if (lotto.get(j) > lotto.get(j + 1)) {
                    int tmp = lotto.get(j);
                    lotto.set(j, lotto.get(j + 1));
                    lotto.set(j + 1, tmp);
                }
            }
        }
    }

    //중복검사
    private static boolean reduplication() {
//        for (int i = 0; i < lotto.length; i++) {
//            if (i == lotto.length - 1) break;
//            else if (lotto[i] == lotto[i + 1]) {
//                lottoGenerate();
//                break;
//            }
//        }
        for (int i = 0; i < lotto.size(); i++) {
            if(i == lotto.size() -1) return true;

            if(lotto.get(i) == lotto.get(i+1)){
                return false;
            }
        }

        return false;
    }
}
