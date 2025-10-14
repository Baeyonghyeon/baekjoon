package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baek_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            nodes[i] = new Node(i, value);
        }

        Arrays.sort(nodes);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int diff = nodes[i].index - i;
            max = Math.max(max, diff);
        }

        System.out.println(max + 1);
    }
}

class Node implements Comparable<Node>{
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
