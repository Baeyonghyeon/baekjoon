package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1300 {

    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        int result = binarySearch(1, k);

        System.out.println(result);
    }

    private static int binarySearch(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }

        return end;
    }
}