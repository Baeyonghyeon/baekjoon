package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek_13023 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static boolean isFriend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];

        // 양방향 노선을 만든후 n ^ 2 계산 방식으로 DFS 를 구성하면 될거같음.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int direct = Integer.parseInt(st.nextToken());

            graph.get(node).add(direct);
            graph.get(direct).add(node);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, 1);

            if (isFriend) break;
        }

        if (isFriend) System.out.println(1);
        else System.out.println(0);

    }

    static void DFS(int node, int count) {
        if (count == 5 || isFriend) {
            isFriend = true;
            return;
        }

        if (!visit[node]) {
            visit[node] = true;
            for (int i = 0; i < graph.get(node).size(); i++) {
                int getNode = graph.get(node).get(i);
                if (!visit[getNode]) {
                    DFS(getNode, count + 1);
                    if (isFriend) {
                        return; // 조기 종료
                    }
                }
            }
        }

        visit[node] = false;
    }
}
