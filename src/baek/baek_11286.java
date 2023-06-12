package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baek_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int o1Abs = Math.abs(o1);
            int o2Abs = Math.abs(o2);
            if (o1Abs == o2Abs) {
                return o1 > o2 ? 1 : -1;
            } else {
                return o1Abs - o2Abs;
            }
        });

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int loop = Integer.parseInt(br.readLine());

            if (loop == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.offer(loop);
            }
        }

        System.out.println(sb);
    }
}
