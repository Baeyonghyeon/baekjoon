package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
        }

        start = Arrays.stream(arr).max().getAsInt();

        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > m) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
