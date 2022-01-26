package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2805 {
    static long N, M, min, mid, max;
    static long tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        tree = new long[(int) N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) max = tree[i];
        }

        long result = 0;
        while (true) {
            mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] - mid > 0) {
                    sum += tree[i] - mid;
                }
            }

            if (sum == M) {
                result = mid;
                break;
            } else if (sum > M) {
                min = mid + 1;
                result = mid;
            } else {  // sum < M
                max = mid - 1;
            }

            if (min > max){
                break;
            }
        }

        System.out.println(result);
    }
}
