package java.javastudy.day7;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;

public class Decimalformat {
    public static void main(String[] args) {
        cf();
        // choiceformat();
    }

    static void df(){
        double d = 123456.789d;
        //#이 아니라 0을 사용하면 자리를 채우기 때문에 보통 #을 사용한다.
        System.out.printf("%f > #.##: %s%n", d, new DecimalFormat("#.##").format(d));
        System.out.printf("%f > 0.00: %s%n", d, new DecimalFormat("0.00").format(d));
        System.out.printf("%f > #######.####: %s%n", d, new DecimalFormat("#######.####").format(d));
        System.out.printf("%f > 0000000.0000: %s%n", d, new DecimalFormat("0000000.0000").format(d));
        System.out.printf("%f > #,###.####: %s%n", d, new DecimalFormat("#,###.####").format(d));
        System.out.printf("%f > 0,000.0000: %s%n", d, new DecimalFormat("0,000.0000").format(d));
        System.out.printf("%f > #.#: %s%n", d, new DecimalFormat("#.#").format(d)); // 반올림
        System.out.printf("%f > #: %s%n", d, new DecimalFormat("#").format(d));     // 반올림
    }

    static void choiceformat(){ // 안씀 몰라도 ㅇㅋ
        // n >= 0: F, n >= 60: D, n >= 70: C, n >= 80: B, n >= 90: A
        double[] minScores = {0, 60, 70, 80, 90};
        String[] grades = {"F", "D", "C", "B", "A"};
        ChoiceFormat gradesFormat = new ChoiceFormat(minScores, grades);

        double[] scores = new double[]{75.6d, 88.8d, 97.3d, 43.3d};
        for (double score : scores) {
            System.out.printf("%.1f => %s%n", score, gradesFormat.format(score));
        }
    }

    static void cf(){
        // n >= 0: F, n >= 60: D, n >= 70: C, n >= 80: B, n >= 90: A
        double[] minScores = {1,3,6,9,12};
        String[] grades = {"겨울", "봄", "여름", "가을", "겨울"};
        ChoiceFormat gradesFormat = new ChoiceFormat(minScores, grades);

        for (int i =1; i<13; i++) {
            System.out.println(i+ "월의 계절은 : " +gradesFormat.format(i));
        }
    }
}
