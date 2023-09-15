package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1920 {

    static int[] list;
    static int[] search;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        search = new int[m];
        for (int i = 0; i < m; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        for (int j = 0; j < m; j++) {
            boolean bl = true;
            int start = 0;
            int end = n-1;

            while (start <= end) {
                int target = (end + start) >> 1;

                if (list[target] == search[j]) {
                    sb.append(1);
                    bl = false;
                    break;
                }
                if (list[target] > search[j]) {
                    end = target - 1;
                }
                if (list[target] < search[j]) {
                    start = target + 1;
                }
            }

            if (bl) {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
