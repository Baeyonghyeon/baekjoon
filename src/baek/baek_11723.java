package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11723 {

    static int[] s = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String h = st.nextToken();
            int x;
//            System.out.println(Arrays.toString(s));

            if (Objects.equals(h, "add")) {
                x = Integer.parseInt(st.nextToken());
                if (s[x] == 0) {
                    s[x] = 1;
                }
            }
            if (Objects.equals(h, "remove")) {
                x = Integer.parseInt(st.nextToken());
                if (s[x] == 1) {
                    s[x] = 0;
                }
            }
            if (Objects.equals(h, "check")) {
                x = Integer.parseInt(st.nextToken());
                if (s[x] == 1) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            if (Objects.equals(h, "toggle")) {
                x = Integer.parseInt(st.nextToken());
                if (s[x] == 1) {
                    s[x] = 0;
                } else {
                    s[x] = 1;
                }
            }
            if (Objects.equals(h, "all")) {
                s = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            }
            if (Objects.equals(h, "empty")) {
                s = new int[21];
            }
        }

        System.out.println(sb);
    }
}
