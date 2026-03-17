package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2230 {

    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(solve());
    }

    private static int solve() {
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (start < n && end < n) {
            int diff = arr[end] - arr[start];

            if (diff < m) {
                end++;
            } else {
                result = Math.min(result, diff);
                start++;

                if (diff == m) break;
            }
        }

        return result;
    }
}
