package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] d = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> getDegree = graph.get(a);
            getDegree.add(b);
            d[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {

                q.offer(i);
                sb.append(i + " ");
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> getDegree = graph.get(poll);

            for (Integer degree : getDegree) {
                d[degree]--;

                if (d[degree] == 0) {
                    q.offer(degree);
                    sb.append(degree + " ");
                }
            }
        }

        System.out.println(sb);
    }
}
