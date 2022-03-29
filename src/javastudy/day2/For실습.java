package javastudy.day2;

import java.util.Scanner;

public class For실습 {
    public static void main(String[] args) {
        For실습 f = new For실습();
        //f.executeFor1();
        //f.excuteFor2();
        //f.excuteFor3();
        //f.gugudan();
        //f.excuteFor4();
        //f.excuteFor5();
        //f.excuteFor6();
        f.fakeDos();
    }

    private void fakeDos() {
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            System.out.print("> ");
            command = sc.next();
            if(command.equals("dir")){
                System.out.println("디렉토리 목록을 출력합니다");
            }else if(command.equals("cp")){
                System.out.println("파일을 복사합니다.");
            }else {
                if(command.equals("quit")){
                    System.out.println("(프로그램 종료)");
                }else{
                    System.out.println("존재하지 않은 명령어입니다.");
                }
            }
        } while (!command.equals("quit"));
    }

    private void excuteFor6() {
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.nextLine();
            System.out.println(str);
        }
    }

    private void excuteFor5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j || i+j == 4){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void gugudan() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.printf("%d * %d =%2d%n", i, j, i * j);
            }
        }
    }

    private void excuteFor4() {
        for (int i = 5; i >= 0; i--) {
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void excuteFor3() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void excuteFor2() {
        for (int i = 65; i < 91; i++) {
            char alpha = (char) i;
            System.out.println(alpha);
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.printf("%c ", i);
        }
    }

    private void executeFor1() {
        int n = 10;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1;
        }
        System.out.printf("sum 1 to %d = %d ", n, sum);
    }


}
