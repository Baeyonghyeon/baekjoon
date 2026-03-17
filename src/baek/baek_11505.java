package baek;

import java.io.*;
import java.util.*;

public class baek_11505 {

    static long[] tree;
    static long DIV_VALUE = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int leafSize = 1;
        while (leafSize <= n) {
            leafSize <<= 1;
        }

        int treeSize = leafSize * 2 + 1;
        tree = new long[treeSize];

        Arrays.fill(tree, 1);
        for (int i = 0; i < n; i++) {
            tree[leafSize + i] = Integer.parseInt(br.readLine());
        }

        initTree(treeSize - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                changeValue(leafSize + b - 1, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(getMulValue(leafSize + b - 1, leafSize + c - 1));
            }
        }
    }

    private static void changeValue(int b, long c) {
        tree[b] = c;

        while (b > 1) {
            tree[b / 2] = tree[b / 2 * 2] % DIV_VALUE * tree[b / 2 * 2 + 1] % DIV_VALUE;
            b /= 2;
        }
    }

    private static long getMulValue(int b, int c) {
        long mulValue = 1;
        while (b <= c) {
            if (b % 2 == 1) mulValue = mulValue % DIV_VALUE * tree[b++] % DIV_VALUE;
            if (c % 2 == 0) mulValue = mulValue % DIV_VALUE * tree[c--] % DIV_VALUE;
            b /= 2;
            c /= 2;
        }

        return mulValue;
    }

    private static void initTree(int treeSize) {
        while (treeSize >= 1) {
            tree[treeSize / 2] = tree[treeSize / 2] % DIV_VALUE * tree[treeSize] % DIV_VALUE;
            treeSize--;
        }
    }

}
