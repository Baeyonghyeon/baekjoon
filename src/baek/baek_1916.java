package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1916 {

    private static List<List<int[]>> graph = new ArrayList<>();
    private static Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

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

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        result[start] = 0;
        dijkstra(start);

        System.out.println(result[end]);
    }

    private static void dijkstra(int start) {
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int a = poll[0];
            int b = poll[1];

            if (b > result[a]) continue;

            for (int[] node : graph.get(a)) {
                int degree = node[0];
                int cost = node[1];

                int newDist = result[a] + cost;
                if (result[degree] > newDist) {
                    result[degree] = newDist;
                    pq.offer(new int[]{degree, newDist});
                }
            }
        }
    }

}
