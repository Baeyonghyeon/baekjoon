package baek;

import java.util.Scanner;

public class baek_10870 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        System.out.println(fibo(N));
    }

    static int fibo(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fibo(N - 2) + fibo(N - 1);
        }
    }
}
