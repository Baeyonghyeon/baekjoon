package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2042 {

    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int leafSize = 1; // k^2
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (leafSize < n) {
            leafSize <<= 1;
        }

        int treeSize = leafSize * 2 + 1;
        tree = new long[treeSize];

        for (int i = 0; i < n; i++) {
            tree[leafSize + i] = Long.parseLong(br.readLine());
        }

        initSumTree(treeSize - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                updateNode(leafSize + b - 1, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(getSum(b + leafSize - 1, c + leafSize - 1));
            }
        }
    }

    public static void initSumTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

    public static void updateNode(int index, long updateValue) {
        long diff = updateValue - tree[index];

        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    public static long getSum(int start, int end) {
        long sum = 0;

        while (start <= end) {
            if (start % 2 == 1) sum += tree[start++];
            if (end % 2 == 0) sum += tree[end--];
            start /= 2;
            end /= 2;
        }

        return sum;
    }
}
