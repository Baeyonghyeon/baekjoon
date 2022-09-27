package coplet;

public class letterCapitalize {
    public static void main(String[] args) {
        String output1 = letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
        String output2 = letterCapitalize("java  is good ");
        System.out.println(output2); // "Java  Is Good "
    }

    public static String letterCapitalize(String str) {
        StringBuilder sb = new StringBuilder();

        // 앞글자가 공백이면 대문자로 toUpperCase 한다.
        // 예외) 1. 첫 시작글자(인덱스[0])
        for (int i = 0; i < str.length(); i++) {
            //String 0번째 글자가 공백이 아니면 대문자로 || 앞글자가 공백이면 대문자로
            if(((i == 0) && (str.charAt(i) != ' ')) || ((str.charAt(i) != ' ') && (str.charAt(i-1) == ' '))) {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }



        return String.valueOf(sb).strip();
    }
}
