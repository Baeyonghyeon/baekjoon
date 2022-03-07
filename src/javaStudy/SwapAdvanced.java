package javaStudy;

public class SwapAdvanced {
    public static void main(String[] args) {
        int a = -2, b = 1;
        System.out.println("a: "+a+",b: "+b);

        a = a*b;
        b = a/b;
        a = a/b;

        System.out.println("After swap. a: " + a + ", b: " + b);
    }ㄹ
}
