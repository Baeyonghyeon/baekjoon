package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N + 1];
        long[] cnt = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
        }

        for (int i = 1; i < N + 1; i++) {
            long remainder = sum[i] % M;
            if (remainder == 0) {
                count++;
            }
            cnt[(int) remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                count += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
        System.out.println(count);
    }
}
