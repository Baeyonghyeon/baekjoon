package javaStudy.day6;

import java.util.Arrays;

public class Clazz {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = DcMoney.class; // 리터럴
        Class clazz2 = new DcMoney(10_000, "WON").getClass();
        Class clazz3 = Class.forName("javaStudy.day6.DcMoney");


        System.out.println("clazz1 : " + clazz1 + " hashcode : " + clazz1.hashCode());
        System.out.println("clazz1 : " + clazz2 + " hashcode : " + clazz2.hashCode());
        System.out.println("clazz1 : " + clazz3 + " hashcode : " + clazz3.hashCode());

        //stringMethod();
        //stringMethod2();
        //stringAppend();

    }

    public static void stringMethod() {
        System.out.println("\"NHN\".charAt(1): " + "NHN".charAt(1));
        System.out.println("\"NHN\".compareTo(\"ACADEMY\"): " + "NHN".compareTo("ACADEMY"));
        System.out.println("\"NHN\".compareTo(\"NHN\"): " + "NHN".compareTo("NHN"));
        System.out.println("\"ACADEMY\".compareTo(\"NHN\"): " + "ACADEMY".compareTo("NHN"));
        System.out.println("\"NHN\".concat(\"ACADEMY\"): " + "NHN".concat("ACADEMY"));
        System.out.println("\"NHN\".equals(\"ACADEMY\"): " + "NHN".equals("ACADEMY"));
        System.out.println("\"NHN\".equals(\"NHN\"): " + "NHN".equals("NHN"));
        System.out.println("\"NHN\".isEmpty(): " + "NHN".isEmpty());
        System.out.println("\"\".isEmpty(): " + "".isEmpty());
        System.out.println("\"NHN\".length(): " + "NHN".length());
        System.out.println("\"NHN\".toLowerCase(): " + "NHN".toLowerCase());
        System.out.println("\"nhn\".toUpperCase(): " + "nhn".toUpperCase());
    }

    public static void stringMethod2(){
        System.out.println("----------------------------------------");
        System.out.println("NHN ACADEMY".indexOf('H'));
        System.out.println("NHN ACADEMY".indexOf(" "));
        System.out.println("NHN ACADEMY".indexOf("MY"));
        System.out.println("NHN ACADEMY".replace("MY", "MY!"));
        System.out.println(Arrays.toString("car,bus,truck".split(",")));
        System.out.println("NHN ACADEMY".startsWith("NHN"));
        System.out.println("NHN ACADEMY".substring(1,5));
        System.out.println(" NHN ACADEMY".trim());
        System.out.println(String.valueOf(1));
    }

    public static void stringAppend(){
        StringBuilder sb = new StringBuilder();
        //1. 문자열과 문자열 사이에는 " "을 추가해주세요
        //2. "nhn", "java"는 대문자로 바꿔주세요
        //3. 마침표 다음에는 다음 라인으로 출력되게 해주세요.
        sb.append("Welcome ").append("to ").append("nhn ".toUpperCase()).append("academy.").append("\n");
        sb.append("You").append(" ").append("are").append(" ").append("learning").append(" ").append("java".toUpperCase()).
                append(" ").append("now");

        System.out.println(sb);
    }
}
