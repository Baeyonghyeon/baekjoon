package javaStudy;

import java.util.Scanner;

public class InchToCm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("cm으로 변경할 inch를 입력하세요.");
        int inch = sc.nextInt();
        System.out.printf("%d inch는 %.2f cm입니다.%n\n", inch, inch * 2.54f);

        System.out.println("cm -> inch로 재변경합니다.");
        float cm = inch * 2.54f;
        inch = (int) (cm / 2.54f);
        System.out.printf("%.2f cm는 %d inch입니다", cm, inch);

        sc.close();
    }
}
