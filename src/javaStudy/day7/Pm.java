package javaStudy.day7;

import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pm {
    public static void main(String[] args) {
        //method2();
        //method3();
        //test();
        //splitTest();
        bigintegerTest();
    }

    private static void bigintegerTest() {
        BigInteger num0 = BigInteger.ZERO;  // 기본 상수
        BigInteger num1 = BigInteger.valueOf(Long.MAX_VALUE);   // long
        BigInteger num2 = new BigInteger("1234567890123456789012345");  // String
        BigInteger num3 = new BigInteger(new byte[]{0xf});  // byte[]

        System.out.println("num0: " + num0);
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num3: " + num3);
    }

    static public void method1() {
        // 'c'로 시작하는 문자열 (c뒤에 문자가 0개 이상 , + == 1개이상)
        Pattern p = Pattern.compile("^c.*");
        Matcher m = p.matcher("car");
        if (m.matches()) {
            System.out.println("Starts with 'c'");
        } else {
            System.out.println("Not starts with 'c'");
        }
    }

    static public void method2() {
        //이메일 찾기
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        while (m.find()) {
            System.out.println("m.groupCount(): " + m.groupCount());
            System.out.println("m.group(): " + m.group());  // m.group(0)
            System.out.println("m.group(1): " + m.group(1));
            System.out.println("m.group(2): " + m.group(2));
        }
    }

    static public void method3() {
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com, qodydgus@naver.com 입니다.");
        StringBuilder result = new StringBuilder();
        while (m.find()) {
            String localPart = m.group(1);
            m.appendReplacement(result, localPart + "@nhnacademy.com");
        }
        m.appendTail(result);
        System.out.println(result);
    }

    static public void test() {
        Pattern p = Pattern.compile("(^032)-(\\d{3,4})-(\\d{3,4})");
        //String list[] = {"032-0032-0320","032-0031-0311" ,"031-031-0310","031-031-0322"}
        Matcher m = p.matcher("032-1234-5678");
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            System.out.println("m.groupCount(): " + m.groupCount());
            System.out.println("m.group(): " + m.group());  // m.group(0)
            System.out.println("m.group(1): " + m.group(1));
            String localPart = m.group(1).replaceAll(m.group(1), "031");
            System.out.println("localPart : " + localPart);
            System.out.println("m.group(2): " + m.group(2));
            System.out.println("m.group(3): " + m.group(3));
        }
        m.appendTail(sb);
        System.out.println(sb);
    }

    static public void splitTest(){
        String input = "50,20,,,40,30";
        // split 정규식 사용가능
        String[] tokens = input.split(",");
        int countBySplit = tokens.length;
        System.out.println("countBySplit: " + countBySplit);
        System.out.println("tokensBySplit");
        for (String token : tokens) {
            System.out.printf("'%s' ", token);
        }
        // StringTokenizer 구분자만 사용가능하다.
        StringTokenizer st = new StringTokenizer(input, ",");
        int countBySt = st.countTokens();
        System.out.printf("%n%ncountBySt: %d%n", countBySt);
        System.out.println("tokensBySt");
        while (st.hasMoreTokens()) {
            System.out.printf("'%s' ", st.nextToken());
        }
    }
}
