package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class baek_1744 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> positivePq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        Queue<Integer> negativePq = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int token = Integer.parseInt(br.readLine());

            if (token <= 0) {
                negativePq.offer(token);
            } else if (token > 0) {
                positivePq.offer(token);
            }
        }

        calc(positivePq);
        calc(negativePq);

        System.out.println(count);
    }

    private static void calc(Queue<Integer> pq) {
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();

            count += Math.max(a * b, a + b);
        }

        if (pq.size() == 1) {
            count += pq.poll();
        }
    }
}
