package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1325 {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] hackCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        hackCount = new int[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 (방향 그래프)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a); // b가 a를 해킹할 수 있음
        }

        int maxHackCount = 0;

        // 각 컴퓨터에서 시작하여 해킹 가능한 컴퓨터 수 계산
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1]; // boolean 배열로 변경
            hackCount[i] = bfs(i);
            maxHackCount = Math.max(maxHackCount, hackCount[i]);
        }

        // StringBuilder로 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hackCount[i] == maxHackCount) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>(); // LinkedList보다 빠름
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드에서 해킹 가능한 모든 컴퓨터 탐색
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++; // 해킹 가능한 컴퓨터 수 증가
                }
            }
        }

        return count;
    }
}