package java.javastudy.day2;

public class ex짝수실습 {
    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.printf("%d ", i);
        }
    }
}
