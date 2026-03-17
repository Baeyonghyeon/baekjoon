package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_13458 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solve(n, b, c));
    }

    private static long solve(int n, int b, int c) {
        long result = n;

        for (int i = 0; i < n; i++) {
            if (arr[i] - b > 0) {
                if ((arr[i] - b) % c == 0)
                    result += (arr[i] - b) / c;
                else
                    result += ((arr[i] - b) / c) + 1;
            }
        }

        return result;
    }
}
