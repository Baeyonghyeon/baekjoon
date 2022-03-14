package javaStudy.day6;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "nhn-academy";
        String s2 = "nhn-academy";
        String ns1 = new String("nhn-academy");
        String ns2 = new String("nhn-academy");

        //intern() 이 내부 메모리(heap)에 동일한 값이 있는지 먼저 찾아보고 있다면 그 값을 가르키기 때문에
        //s1 == s2는 true가 나온다.
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == ns1: " + (s1 == ns1));
        System.out.println("ns1 == ns2: " + (ns1 == ns2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(ns1): " + s1.equals(ns1));
        System.out.println("ns1.equals(ns2): " + ns1.equals(ns2));
    }
}