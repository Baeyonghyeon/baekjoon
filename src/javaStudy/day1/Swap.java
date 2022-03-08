package javaStudy.day1;

public class Swap {
    public static void main(String[] args) {
        int a = 10, b = 20;
        int tmp;
        System.out.println("a: "+ a + ", b: "+ b);

        tmp = a;
        System.out.println("tmp: "+ tmp +", a: "+ a + ", b: "+ b);
        a = b;
        System.out.println("tmp: "+ tmp +", a: "+ a + ", b: "+ b);
        b = tmp;
        System.out.println("After Swap a: "+ a + ", b: "+ b);
    }
}
