package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1516 {

    private static int[] leadTime;
    private static int[] d;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        leadTime = new int[n + 1];
        d = new int[n + 1];
        result = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            leadTime[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                if (token == -1) {
                    break;
                }

                List<Integer> degrees = graph.get(token);
                degrees.add(i);
                d[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                result[i] = leadTime[i];
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> degrees = graph.get(poll);

            for (Integer degree : degrees) {
                d[degree]--;
                result[degree] = Math.max(result[poll] + leadTime[degree], result[degree]);

                if (d[degree] == 0) {
                    q.offer(degree);
                }
            }
            ;
        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
