package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11724_2 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int indirect = Integer.parseInt(st.nextToken());

            graph.get(node).add(indirect);
            graph.get(indirect).add(node);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!visit[i]){
                count++;
                DFS(i);
            }

        }

        System.out.println(count);
    }

    static void DFS(int value) {
        if (visit[value]) {
            return;
        }

        visit[value] = true;
        for (int n : graph.get(value)) {
            DFS(n);
        }
    }
}
