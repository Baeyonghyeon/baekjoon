package javaStudy.day3;

public class factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(whileFactorial(10));
    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int whileFactorial(int n){
        int result = 1;
        int start = 1;
        while (true){
            if(n == 1) return n;
            else {
                result *= ++start;
            }

            if(start == n) break;
        }
        return result;
    }
}
