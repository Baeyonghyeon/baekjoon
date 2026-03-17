package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_11725 {

    private static List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] visit;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree.add(new LinkedList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        visit[1] = true;
        DFS(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(result[i]);
        }
    }

    private static void DFS(int num) {
        for (Integer child : tree.get(num)) {
            if (!visit[child]) {
                result[child] = num;
                visit[child] = true;
                DFS(child);
            }
        }
    }

}
