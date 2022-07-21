package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class programmers_멀리뛰기 {
    static int ary[] = new int[2000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ary[0] = 1;
        ary[1] = 2;

        if (n > 1) {
            for (int i = 2; i < n; i++) {
                ary[i] = (ary[i-2] + ary[i-1]) % 1234567;
            }
        }

        System.out.println(ary[n-1]);
    }
    //커밋이 안찍혀
}
