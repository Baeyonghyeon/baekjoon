package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1991 {

    private static int[][] tree = new int[26][2];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            Arrays.fill(tree[i], -1);
        }

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            int root = charArray[0] - 'A';
            int left = charArray[2] != '.' ? charArray[2] - 'A' : -1;
            int right = charArray[4] != '.' ? charArray[4] - 'A' : -1;

            tree[root][0] = left;
            tree[root][1] = right;
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    private static void preOrder(int c) { // 전위 mid, left, right
        sb.append((char) (c + 'A'));

        if (tree[c][0] != -1)
            preOrder(tree[c][0]);

        if (tree[c][1] != -1)
            preOrder(tree[c][1]);
    }

    private static void inOrder(int c) { // 중위 left, mid, right
        if (tree[c][0] != -1)
            inOrder(tree[c][0]);

        sb.append((char) (c + 'A'));

        if (tree[c][1] != -1)
            inOrder(tree[c][1]);
    }

    private static void postOrder(int c) { // 후위 left, right, mid
        if (tree[c][0] != -1)
            postOrder(tree[c][0]);

        if (tree[c][1] != -1)
            postOrder(tree[c][1]);

        sb.append((char) (c + 'A'));
    }
}
