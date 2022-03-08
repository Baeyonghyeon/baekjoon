package javaStudy.day2;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("월을 입력하세요: ");
        int month = sc.nextInt();
        printDaysInMonth(month);
        ifprintDaysInMonth(month);
        forDaysMonth();
    }

    //for문을 사용해 1월부터 12월까지 각각 해당 월에 며칠까지 있는지 출력하는것임.
    private static void forDaysMonth() {
        for(int i=1; i <= 12; i++){
            printDaysInMonth(i);
        }
    }

    private static void printDaysInMonth(int month) {
        //case 예제는 무조건 break 를 넣어주어야 한다 안그러면 다음 case 문도 실행됨.
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + " has 31 days.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + " has 30 days.");
                break;
            case 2:
                System.out.println(month + " has 28 or 29 days.");
                break;
            default:
                System.out.println(month + "is not a month");
                break;
        }
    }

    private static void ifprintDaysInMonth(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            System.out.println(month + " has 31 days.");
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            System.out.println(month + " has 30 days.");
        else if (month == 2) System.out.println(month + " has 28 or 29 days.");
        else System.out.println(month + "is not a month");
    }
}
