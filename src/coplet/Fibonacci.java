package coplet;

import java.util.Arrays;

public class Fibonacci {
    static int[] ary;

    public static void main(String[] args) {
        int output = fibonacci(0);
        System.out.println(output); // --> 0

        output = fibonacci(1);
        System.out.println(output); // --> 1

        output = fibonacci(5);
        System.out.println(output); // --> 5

        output = fibonacci(9);
        System.out.println(output); // --> 34
    }

    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }

        ary = new int[num + 1];
        Arrays.fill(ary, -1);
        ary[0] = 0;
        ary[1] = 1;

        return fibo(num);
    }

    public static int fibo(int num) {
        if (ary[num] == -1) {
            ary[num] = fibo(num - 1) + fibo(num - 2);
        }
        return ary[num];
    }
}
