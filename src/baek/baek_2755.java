package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double total = 0;   // 학점 * 성적 / 총학점
        double credit =0;   //총학점

        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split(" ");
            double x = Integer.parseInt(token[1]);
            double y = rank(token[2]);
            total += x*y;
            credit += x;
        }
        total /= credit;
        System.out.println(String.format("%.2f",total));


    }

    static double rank(String str) {
        if (str.equals("A+")) {
            return 4.3;
        } else if (str.equals("A0")) {
            return 4.0;
        } else if (str.equals("A-")) {
            return 3.7;
        } else if (str.equals("B+")) {
            return 3.3;
        } else if (str.equals("B0")) {
            return 3.0;
        } else if (str.equals("B-")) {
            return 2.7;
        } else if (str.equals("C+")) {
            return 2.3;
        } else if (str.equals("C0")) {
            return 2.0;
        } else if (str.equals("C-")) {
            return 1.7;
        } else if (str.equals("D+")) {
            return 1.3;
        } else if (str.equals("D0")) {
            return 1.0;
        } else if (str.equals("D-")) {
            return 0.7;
        } else return 0.0;
    }
}
