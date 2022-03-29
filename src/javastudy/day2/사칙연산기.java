package javastudy.day2;

import java.util.Scanner;

public class 사칙연산기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("어떤 연산을 하실건가요?(+,-,*,/)");
        String input = sc.next();

        System.out.println("피연산자 2수를 입력하세요.");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = 0;

        if (input.equals("+")) result = a + b;
        else if (input.equals("-")) result = a - b;
        else if (input.equals("*")) result = a * b;
        else if (input.equals("/")) result = a + b;
        System.out.println(a + " " + input + " " + b + " = " + result + "입니다.");
    }
}
