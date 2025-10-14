package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_17472 {

    private static List<int[]> nodes = new ArrayList<>(); // 브릿지 길이넣을 녀석
    private static int[] xi = new int[]{-1, 1, 0, 0};
    private static int[] yi = new int[]{0, 0, -1, 1};
    private static int count = 1;
    private static boolean[][] visit;
    private static int[][] graph;
    private static int n, m;
    private static int[] unionFind;
    private static int result = 0;
    // 노드간의 degree를 구한 graph를 만들고, 프림 알고리즘으로 MST를 구해야 함.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int startNode;
                if (graph[i][j] != 0) {
                    startNode = graph[i][j];
                    bridgeBuild(startNode, i, j);
                }
            }
        }

        // MST 구하기
        unionFind = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            unionFind[i] = i;
        }
        nodes.sort(Comparator.comparingInt(o -> o[2]));

        for (int[] node : nodes) {
            int startNode = node[0];
            int endNode = node[1];

            if (startNode != endNode) {
                union(startNode, endNode, node[2]);
            }
        }

        boolean flag = true;
        for (int i = 2; i < count; i++) {
            if (find(i) != find(1)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void BFS(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visit[a][b] = true;
        graph[a][b] = count; // 시작점에 섬 번호 할당

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i = 0; i < 4; i++) {
                int yy = y + yi[i];
                int xx = x + xi[i];

                if (yy >= 0 && yy < n && xx >= 0 && xx < m && graph[yy][xx] == 1 && !visit[yy][xx]) {
                    visit[yy][xx] = true;
                    q.offer(new int[]{yy, xx});
                    graph[yy][xx] = count;
                }
            }
        }
    }

    private static void bridgeBuild(int startNode, int a, int b) {
        for (int i = 0; i < 4; i++) {
            int yy = a;
            int xx = b;
            int bridgeLength = 0;

            while (true) {
                int nextY = yy + yi[i];
                int nextX = xx + xi[i];

                // 범위 체크 먼저
                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    break;
                }

                // 다른 섬에 도착
                if (graph[nextY][nextX] != 0) {
                    if (startNode != graph[nextY][nextX] && bridgeLength > 1) {
                        nodes.add(new int[]{startNode, graph[nextY][nextX], bridgeLength});
                    }
                    break;
                }

                // 바다면 계속 진행
                yy = nextY;
                xx = nextX;
                bridgeLength++;
            }
        }
    }

    private static void union(int a, int b, int degree) {
        a = find(a);
        b = find(b);

        if (a != b) {
            unionFind[a] = b;
            result += degree;
        }
    }

    private static int find(int a) {
        if (unionFind[a] == a) return a;
        else return unionFind[a] = find(unionFind[a]);
    }

}
