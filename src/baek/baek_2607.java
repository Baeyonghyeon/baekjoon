package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2607 {
    static int[] ary1 = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        String first = br.readLine();

        for (int i = 0; i < first.length(); i++) {
            ary1[first.charAt(i) - 65]++;
        }

        for (int i = 1; i < n; i++) {
            String str = br.readLine();
            int plwarn = 0;
            int miwarn = 0;
            int[] ary2 = new int[26];
            Arrays.fill(ary2, 0);
            int cal;

            for (int j = 0; j < str.length(); j++) {
                ary2[str.charAt(j) - 65]++;
            }

            for (int j = 0; j < 26; j++) {
                cal = ary1[j] - ary2[j];
                if (cal == 1) {
                    plwarn++;
                } else if (cal == -1) {
                    miwarn++;
                } else if (cal != 0) {
                    plwarn = 100;
                    break;
                }
            }

            if (miwarn < 2 && plwarn < 2) {
                System.out.println(str);
                result++;
            }
        }

        System.out.println(result);
    }
}