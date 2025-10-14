package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1920 {

    static boolean[] targets;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        targets = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            targets[target] = true;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);


    }

    static boolean binarySearch(int start, int end, int target) {
        int mid = (start + end) / 2;

        while (start <= end) {
            if(a[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return true;
    }
}
