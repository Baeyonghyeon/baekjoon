package java.javastudy.day2;

import java.util.Scanner;

public class 사칙연산누산기 {
    static int result;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean bl = first();

        if (bl) {
            while (true) {
                System.out.println("어떤 연산을 하실건가요?(+,-,*,/) 종료는 'q'입니다.");
                String input = sc.next();

                if (input.equals("q")) {
                    System.out.println("종료합니다.");
                    break;
                }

                System.out.println("피연산자 1수를 입력하세요.");
                int a = sc.nextInt();
                int beforeResult = result;

                if (input.equals("+")) result += a;
                else if (input.equals("-")) result -= a;
                else if (input.equals("*")) result *= a;
                else if (input.equals("/")) result /= a;
                System.out.println(beforeResult + " " + input + " " + a + " = " + result + "입니다.");
            }
        }
    }

    static boolean first() {

        System.out.println("어떤 연산을 하실건가요?(+,-,*,/) 종료는 'q'입니다.");
        String input = sc.next();

        if (input.equals("q")) {
            System.out.println("종료합니다.");
            return false;
        }

        System.out.println("피연산자 2수를 입력하세요.");
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (input.equals("+")) result = a + b;
        else if (input.equals("-")) result = a - b;
        else if (input.equals("*")) result = a * b;
        else if (input.equals("/")) result = a + b;
        System.out.println(a + " " + input + " " + b + " = " + result + "입니다.");

        return true;
    }
}
