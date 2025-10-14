package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1219 {

    private static List<List<int[]>> graph = new ArrayList<>();
    private static long[] result;
    private static long[] pay;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = new long[n];
        pay = new long[n];
        Arrays.fill(result, Long.MIN_VALUE);

        for (int i = 0; i < n; i++) {
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
        for (int i = 0; i < n; i++) {
            pay[i] = Long.parseLong(st.nextToken());
        }

        boolean flag = bfm(start, end);

        if (flag) {
            System.out.println("Gee");
        } else {
            if (result[end] == Long.MIN_VALUE) System.out.println("gg");
            else System.out.println(result[end]);
        }
    }

    private static boolean bfm(int start, int end) {
        result[start] = pay[start];
        boolean flag = false;

        for (int i = 0; i < n - 1; i++) {
            for (int current = 0; current < n; current++) {
                for (int[] edge : graph.get(current)) {
                    int next = edge[0];
                    int cost = edge[1];

                    if (result[current] != Long.MIN_VALUE) {
                        long newDist = result[current] - cost + pay[next];
                        if (newDist > result[next]) {
                            result[next] = newDist;
                        }
                    }

                }
            }
        }

        for (int current = 0; current < n; current++) {
            for (int[] edge : graph.get(current)) {
                int next = edge[0];
                int cost = edge[1];

                // result값이 더 커지게 된다면, 무한으로 돈을 벌 수있다는 뜻이고, current 에서 시작하는게 end까지 도달하는지 BFS 후 boolean return
                if (result[current] != Long.MIN_VALUE && result[current] - cost + pay[next] > result[next]) {
                    if (reachToEnd(next, end)) {
                        return true;
                    }
                }
            }
        }

        return flag;
    }

    private static boolean reachToEnd(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        Arrays.fill(visit, false);
        q.offer(start);
        boolean flag = false;

        while (!q.isEmpty() && !flag) {
            int poll = q.poll();
            visit[poll] = true;

            for (int[] nodes : graph.get(poll)) {
                int next = nodes[0];

                if (!visit[next]) {
                    q.offer(next);
                }

                if (next == end) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }
}
