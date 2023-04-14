package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek_2075 {
    /**
     *  우선순위큐를 사용해 값을 넣고 N 번째로 큰수를 뽑자.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.valueOf(st.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
