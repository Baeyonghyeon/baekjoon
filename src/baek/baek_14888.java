package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14888 {

    static int[] arr;
    static int[] oper;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        oper = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int current, int count) {
        if (count == n) {
            max = Math.max(current, max);
            min = Math.min(current, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] <= 0) continue;

            oper[i]--;
            int nextValue = calc(current, arr[count], i);
            solve(nextValue, count + 1);
            oper[i]++;
        }

    }

    private static int calc(int a, int b, int op) {
        if (op == 0) return a + b;
        if (op == 1) return a - b;
        if (op == 2) return a * b;
        else return a / b;
    }
}
