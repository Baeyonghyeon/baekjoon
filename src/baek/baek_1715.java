package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class baek_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.valueOf(br.readLine()));
        }

        for (int i = 0; i < n-1; i++) {
            int addValue = pq.poll() + pq.poll();
            count += addValue;
            pq.offer(addValue);
        }

        System.out.println(count);
    }
}
