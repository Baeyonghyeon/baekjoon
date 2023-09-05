package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int st1 = Integer.parseInt(st.nextToken());
            int st2 = Integer.parseInt(st.nextToken());

            if (st1 == 1) {
                for (int j = 1; j <= n; j++) {
                    if (j % st2 == 0) {
                        if (ary[j] == 0) {
                            ary[j] = 1;
                        } else {
                            ary[j] = 0;
                        }
                    }
                }
            } else {
                if (ary[st2] == 0) {
                    ary[st2] = 1;
                } else {
                    ary[st2] = 0;
                }
                int left = st2 - 1;
                int right = st2 + 1;
                while (left > 0 && right <= n && (ary[left] == ary[right])) {
                    if (ary[left] == 1) {
                        ary[left] = 0;
                        ary[right] = 0;
                    } else {
                        ary[left] = 1;
                        ary[right] = 1;
                    }

                    left--;
                    right++;
                }
            }

//            System.out.println(Arrays.toString(ary));
        }
        for (int i = 1; i <= n; i++) {
            sb.append(ary[i]).append(" ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
