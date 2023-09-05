package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int start = 0;
        int end = N - 1;
        int ans1 = 0;
        int ans2 = 0;
        int total = Integer.MAX_VALUE;
//        1 2 3 4 5  6 7 10

        while (start < end) {
            int sum = list[start] + list[end];

            if (total > Math.abs(sum)) {
                total = Math.abs(sum);
                ans1 = list[start];
                ans2 = list[end];
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
