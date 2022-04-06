package java.javastudy.day2;

import java.util.Scanner;

public class GradePrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요");
        int score = sc.nextInt();

        GradePrinter gradePrinter = new GradePrinter();
        //gradePrinter.print(score);
        gradePrinter.삼항연산자(score);
    }

    private void 삼항연산자(int score) {
        System.out.println("Grade: " + (score >= 90 ? "A" : score >= 80 ? "B" : "F"));
    }

    private void print(int score) {
        if (score >= 90) System.out.println("A");
        else if (score >= 80) System.out.println("B");
        else if (score >= 70) System.out.println("C");
        else if (score >= 60) System.out.println("D");
        else System.out.println("F");
    }
}
