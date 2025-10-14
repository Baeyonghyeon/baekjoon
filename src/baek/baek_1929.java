package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1929 {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] bl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bl = new boolean[m + 1];
        bl[1] = true;

        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (bl[i]) continue;

            for (int j = i * 2; j <= m; j++) {
                if (j % i == 0) bl[j] = true;
            }
        }

        for (int i = n; i < m + 1; i++) {
            if (!bl[i]) System.out.println(i);
        }
    }
}
