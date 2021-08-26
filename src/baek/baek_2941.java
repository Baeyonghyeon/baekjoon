package baek;

import java.util.Scanner;

public class baek_2941 {
    private static String input;
    private static int count;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        input = scan.nextLine();
        count = input.length(); //초기에 문자만큼 개수를 카운트함
        String[] ary;
        //한개씩 끊어서 배열에 저장
        ary = input.split("");

        for (int i = 0; i < input.length(); i++) {


            if (i < input.length() - 2) {
                if (ary[i].equals("d") && ary[i + 1].equals("z") && ary[i + 2].equals("=")) {
                    count -= 2;
                    i += 2;
                }
            }

            if (i < input.length() - 1) {
                if (ary[i].equals("c") && ary[i + 1].equals("=")) {
                    count--;
                    i++;
                } else if (ary[i].equals("c") && ary[i + 1].equals("-")) {
                    count--;
                    i++;
                } else if (ary[i].equals("d") && ary[i + 1].equals("-")) {
                    count--;
                    i++;
                } else if (ary[i].equals("l") && ary[i + 1].equals("j")) {
                    count--;
                    i++;
                } else if (ary[i].equals("n") && ary[i + 1].equals("j")) {
                    count--;
                    i++;
                } else if (ary[i].equals("s") && ary[i + 1].equals("=")) {
                    count--;
                    i++;
                } else if (ary[i].equals("z") && ary[i + 1].equals("=")) {
                    count--;
                    i++;
                }
            }
        }
        System.out.println(count);
    }
}
