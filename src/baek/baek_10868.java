package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_10868 {

    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int leafSize = 1;
        while (leafSize <= n) {
            leafSize <<= 1;
        }

        int treeSize = leafSize * 2 + 1;
        tree = new int[treeSize];

        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            tree[leafSize + i] = Integer.parseInt(br.readLine());
        }

        initMinTree(leafSize + n - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(getMinValue(leafSize + a - 1, leafSize + b - 1));
        }
    }

    private static int getMinValue(int a, int b) {
        int min = Integer.MAX_VALUE;

        while (a <= b) {
            if (a % 2 == 1) min = Math.min(min, tree[a++]);
            if (b % 2 == 0) min = Math.min(min, tree[b--]);

            a /= 2;
            b /= 2;
        }

        return min;
    }

    private static void initMinTree(int i) {
        while (i != 1) {
            if (tree[i / 2] > tree[i]) {
                tree[i / 2] = tree[i];
            }
            i--;
        }
    }
}
