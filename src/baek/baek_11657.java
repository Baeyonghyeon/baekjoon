package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11657 {

    private static List<List<int[]>> graph = new ArrayList<>();
    private static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = new long[n + 1];
        Arrays.fill(result, Long.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
        }

        boolean flag = bfm(1, n);

        if (flag) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (result[i] == Long.MAX_VALUE) System.out.println(-1);
                else System.out.println(result[i]);
            }
        }
    }


    private static boolean bfm(int start, int n) {
        result[start] = 0;
        boolean flag = false;

        for (int i = 0; i < n - 1; i++) {
            for (int current = 1; current <= n; current++) {
                for (int[] edge : graph.get(current)) {
                    int next = edge[0];
                    int cost = edge[1];

                    if (result[current] != Long.MAX_VALUE && result[current] + cost < result[next]) {
                        result[next] = result[current] + cost;
                    }

                }
            }
        }

        for (int current = 1; current <= n; current++) {
            for (int[] edge : graph.get(current)) {
                int next = edge[0];
                int cost = edge[1];

                if (result[current] != Long.MAX_VALUE && result[current] + cost < result[next]) {
                    flag = true;
                }

                if (flag) break;
            }
            if (flag) break;
        }


        return flag;
    }
}
