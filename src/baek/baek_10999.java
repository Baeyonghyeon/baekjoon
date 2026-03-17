package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10999 {

    static long[] tree;
    static long[] lazy;
    static int leafSize = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (leafSize <= n) {
            leafSize <<= 1;
        }
        tree = new long[leafSize * 2 + 1];
        lazy = new long[leafSize * 2 + 1];

        for (int i = 0; i < n; i++) {
            tree[leafSize + i] = Long.parseLong(br.readLine());
        }
        initTree(leafSize * 2);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(1, 1, leafSize, b, c, d);
            } else {
                sb.append(query(1, 1, leafSize, b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void initTree(int treeSize) {
        for (int i = treeSize; i > 0; i--) {
            tree[i / 2] += tree[i];
        }
    }

    private static void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private static void update(int node, int start, int end, int left, int right, long value) {
        propagate(node, start, end);

        if (right < start || end < left) return;

        if (left <= start && end <= right) {
            lazy[node] += value;
            propagate(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, value);
        update(node * 2 + 1, mid + 1, end, left, right, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);

        if (right < start || end < left) return 0;

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

}
