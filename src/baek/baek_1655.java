package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class baek_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> lowQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> highQ = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                lowQ.offer(input);

                if (lowQ.size() > 1 && lowQ.peek() > highQ.peek()) {
                    highQ.offer(lowQ.poll());
                    lowQ.offer(highQ.poll());
                }
            } else {
                highQ.offer(input);

                if (lowQ.peek() > highQ.peek()) {
                    highQ.offer(lowQ.poll());
                    lowQ.offer(highQ.poll());
                }
            }

            sb.append(lowQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
