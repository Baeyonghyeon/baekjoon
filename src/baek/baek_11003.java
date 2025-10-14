package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11003 {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Node node = new Node(i, Integer.parseInt(st.nextToken()));

            if (queue.isEmpty()) {
                queue.offerLast(node);
            } else {
                if (queue.peekLast().value < node.value) {
                    queue.offerLast(node);
                } else {
                    while (!queue.isEmpty() && queue.peekLast().value > node.value) {
                        queue.pollLast();
                    }
                    queue.offerLast(node);
                }
            }

            while (!queue.isEmpty() && queue.peekFirst().index < i - L + 1) {
                queue.pollFirst();
            }

            sb.append(queue.peekFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
