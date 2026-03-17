package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1068 {

    private static List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] visit;
    private static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            tree.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree.get(parent).add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        visit[deleteNode] = true;
        DFS(deleteNode);

        System.out.println(countLeaf(root));
    }

    private static void DFS(int deleteNode) {
        for (Integer node : tree.get(deleteNode)) {
            if (!visit[node]) {
                visit[node] = true;
                DFS(node);
            }
        }
    }

    private static int countLeaf(int node) {
        if (visit[node]) return 0;

        int leafCount = 0;

        for (Integer child : tree.get(node)) {
            if (!visit[child]) {
                leafCount += countLeaf(child);
            }
        }

        return leafCount == 0 ? 1 : leafCount;
    }
}
