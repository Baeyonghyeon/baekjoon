package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14501 {
    static int D[];
    static int T[];
    static int P[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        D = new int[N + 2];
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int current = N - i;

            if ((current + T[current]) <= N + 1) {
                D[current] = Math.max(D[current + 1], (D[current + T[current]] + P[current]));
            } else {
                D[current] = D[current + 1];
            }
        }

        System.out.println(D[1]);
    }
}
