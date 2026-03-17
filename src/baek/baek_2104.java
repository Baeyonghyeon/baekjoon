package baek;

import java.util.*;
import java.io.*;

public class baek_2104 {

    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long result = solve(0, n - 1);
        System.out.println(result);
    }

    private static long solve(int start, int end) {
        if (start == end) {
            return arr[start] * arr[start];
        }

        int mid = (start + end) / 2;
        long leftMax = solve(start, mid);
        long rightMax = solve(mid + 1, end);

        int left = mid;
        int right = mid + 1;
        long sum = arr[mid] + arr[mid + 1];
        long min = Math.min(arr[mid], arr[mid + 1]);
        long crossMax = sum * min;

        while (left > start || right < end) {
            if (left == start) {
                right++;
                sum += arr[right];
                min = Math.min(min, arr[right]);
            } else if (right == end) {
                // 오른쪽 끝 도달, 왼쪽만 확장
                left--;
                sum += arr[left];
                min = Math.min(min, arr[left]);
            } else {
                // 둘 다 확장 가능, 더 큰 값 쪽으로 확장
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
            crossMax = Math.max(crossMax, sum * min);
        }

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
}
