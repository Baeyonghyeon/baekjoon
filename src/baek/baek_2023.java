package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.println(sb);
    }

    private static void DFS(int a, int b) {
        if (N == b) {
            if (isPrimeNumber(a)) {
                sb.append(a).append("\n");
            }

            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            if (isPrimeNumber(a * 10 + i)) {
                DFS(a * 10 + i, b + 1);
            }
        }
    }

    private static boolean isPrimeNumber(int checkNumber) {
        for (int i = 2; i <= Math.sqrt(checkNumber); i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }

        return true;
    }
}
