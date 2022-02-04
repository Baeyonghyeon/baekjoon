package baek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_가장먼노드 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visit[];
    static int count[];
    static int value = 0;

    public static void main(String[] args) {
        int n = 6;
        int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        soultion(n, edge);
    }

    static void soultion(int n, int[][] edge) {
        visit = new boolean[n + 1];
        count = new int[n + 1];

        // 0은 포함하지 않고 6까지 넣음
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 간선 넣기 (양방향)
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        bfs(1);

        int max = Arrays.stream(count).max().getAsInt();

        for (int i : count) {
            if (max == i) value++;
        }

        System.out.println(value);
    }

    static void bfs(int V) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList();
        q.offer(V);
        visit[V] = true;
        count[V] = cnt;

        while (!q.isEmpty()) {
            V = q.poll();
            visit[V] = true;

            for (int i : graph.get(V)) {
                if (!visit[i] && count[i] == 0) {
                    q.offer(i);
                    visit[i] = true;
                    count[i] = count[V]+1;
                }
            }
//            System.out.println(Arrays.toString(visit));
//            System.out.println(Arrays.toString(count));
        }
    }
}
