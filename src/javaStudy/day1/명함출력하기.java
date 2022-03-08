package javaStudy.day1;

import java.util.Scanner;

public class 명함출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input name: ");
        String name = sc.nextLine();
        System.out.print("input email: ");
        String email = sc.nextLine();
        System.out.print("input mobile: ");
        String mobile = sc.nextLine();
        System.out.println("OK\n");

        System.out.println("name:" + name);
        System.out.println("email:" + email);
        System.out.println("mobile:" + mobile);

        sc.close();
    }
}
