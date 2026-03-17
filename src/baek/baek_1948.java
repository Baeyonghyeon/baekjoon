package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1948 {
    private static int[] dist;
    private static int[] inDegree;
    private static List<List<int[]>> graph = new ArrayList<>();
    private static List<List<int[]>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        inDegree = new int[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // 간선 정보 입력 (정방향과 역방향 모두)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new int[]{to, cost});
            reverseGraph.get(to).add(new int[]{from, cost}); // 역방향 그래프
            inDegree[to]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        // 1단계: 위상정렬로 최장 시간 구하기
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] edge : graph.get(current)) {
                int next = edge[0];
                int cost = edge[1];

                dist[next] = Math.max(dist[next], dist[current] + cost);
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 2단계: 역추적으로 임계 경로의 간선 개수 구하기
        boolean[] visited = new boolean[n + 1];
        queue = new LinkedList<>();
        queue.offer(finish);
        visited[finish] = true;

        int criticalEdgeCount = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] edge : reverseGraph.get(current)) {
                int prev = edge[0];
                int cost = edge[1];

                // 임계 간선 판별: dist[prev] + cost == dist[current]
                if (dist[prev] + cost == dist[current]) {
                    criticalEdgeCount++;

                    if (!visited[prev]) {
                        visited[prev] = true;
                        queue.offer(prev);
                    }
                }
            }
        }

        System.out.println(dist[finish]); // 최장 시간
        System.out.println(criticalEdgeCount); // 임계 간선 개수
    }
}