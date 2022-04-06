package java.javastudy.day1;

import java.util.Scanner;

public class 유니코드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextLine().charAt(0);
        System.out.printf(String.format("\\u%04x", input));

        sc.close();
    }

}
