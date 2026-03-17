package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2104_1 {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recursive(0, n - 1));
    }

    public static long recursive(int start, int end) {
        if (start == end) {
            return (long) arr[start] * arr[start];
        }

        int mid = (start + end) / 2;
        int left = mid;
        int right = mid + 1;
        long sum = (long) arr[mid] + arr[mid + 1];
        int min = Math.min(arr[mid], arr[mid + 1]);
        long crossCalValue = sum * min;

        long leftMaxValue = recursive(start, mid);
        long rightMaxValue = recursive(mid + 1, end);

        while (left > start || right < end) {
            if (left == start) {
                right++;
                sum += arr[right];
                min = Math.min(min, arr[right]);

            } else if (right == end) {
                left--;
                sum += arr[left];
                min = Math.min(min, arr[left]);

            } else {
                if (arr[left - 1] > arr[right + 1]) {
                    left--;
                    sum += arr[left];
                    min = Math.min(min, arr[left]);
                } else {
                    right++;
                    sum += arr[right];
                    min = Math.min(min, arr[right]);
                }
            }

            crossCalValue = Math.max(crossCalValue, sum * min);
        }

        return Math.max(crossCalValue, Math.max(leftMaxValue, rightMaxValue));
    }
}
