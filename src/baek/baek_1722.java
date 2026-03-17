package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1722 {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static boolean[] permutation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        permutation = new boolean[n + 1];
        Arrays.fill(permutation, false);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        if (k == 1) {
            long seq = Long.parseLong(st.nextToken());

            for (int i = 1; i <= n; i++) {
                int target = 0;
                int loop = 1;

                while ((long) (n - i) * loop < seq) {
                    target++;
                    loop += 1;
                }

                findDisuseNumber(target);
            }
        }

        System.out.println(sb);
    }

    private static void findDisuseNumber(int target) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!permutation[i]) {
                count++;

                if (count == target) {
                    sb.append(i).append(" ");
                    permutation[i] = true;
                    break;
                }
            }
        }

    }
}
