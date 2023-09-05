package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(list);
//        System.out.println(Arrays.toString(list));
        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            if (list[start] + list[end] > x) {
                end--;
            } else if (list[start] + list[end] < x) {
                start++;
            } else {
//                System.out.println("합 " + list[start] + ", " + list[end]);
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}
