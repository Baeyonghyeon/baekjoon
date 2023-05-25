package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baek_11003 {
    public static void main(String[] args) throws IOException {
        Deque<int[]> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        deque.offerLast(new int[]{1, Integer.parseInt(st.nextToken())});
        sb.append(deque.peekFirst()[1]).append(" ");

        for (int i = 2; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast()[1] > a) {
                deque.pollLast();
            }

            deque.offerLast(new int[]{i, a});

            if(deque.peekFirst()[0] == i - L){
                deque.pollFirst();
            }


            sb.append(deque.peekFirst()[1]).append(" ");
        }

        System.out.println(sb);
    }
}
