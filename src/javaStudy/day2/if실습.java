package javaStudy.day2;

public class if실습 {
    public static void main(String[] args) {
        int month = 4;
        if (month >= 3) {
            System.out.println("Greather than or equal 3");
        }
        if (isSpring(month)){
            System.out.println("flowers bloom");
        }

    }

    private static boolean isSpring(int month) {
        return month >= 3 && month <= 5;
    }
}
