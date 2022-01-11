package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baek_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while (N-->0){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(q.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else {
                q.offer(n);
            }
        }

        System.out.println(sb);
    }
}
