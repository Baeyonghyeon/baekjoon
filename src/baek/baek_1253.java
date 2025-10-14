package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (arr[start] + arr[end] == target) {
                    if (i != start && i != end) {
                        count++;
                        break;
                    } else {
                        if (i == start) start++;
                        if (i == end) end--;
                    }
                } else if (arr[start] + arr[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(count);
    }
}
