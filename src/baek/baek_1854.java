package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1854 {
    private static List<Queue<Integer>> result = new ArrayList<>();
    private static List<List<int[]>> graph = new ArrayList<>();
    private static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            result.add(new PriorityQueue<>(k, (o1, o2) -> o2 - o1));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cost});
        }

        dijkstra(1, k);

        for (int i = 1; i <= n; i++) {
            System.out.println(result.get(i).size() < k ? -1 : result.get(i).peek());
        }
    }

    private static void dijkstra(int start, int k) {
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int current = poll[0];
            int dist = poll[1];

            if (result.get(current).size() == k && result.get(current).peek() <= dist) continue;

            if (result.get(current).size() == k) result.get(current).poll();
            result.get(current).offer(dist);


            for (int[] edge : graph.get(current)) {
                int next = edge[0];
                int cost = edge[1];
                int newDist = dist + cost;
                //pq 에 알맞게 넣을만한 조건인지 확인해서 넣어야 함
                if (result.get(next).size() < k || result.get(next).peek() > newDist) {
                    pq.offer(new int[]{next, newDist});
                }
            }
        }
    }

}
