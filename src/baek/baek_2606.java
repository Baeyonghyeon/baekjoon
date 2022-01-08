package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baek_2606 {
    public static int count = 0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        // 컴퓨터 개수
        int edge = Integer.parseInt(br.readLine());     // 간선 수

        for (int i = 0; i < T + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edge; i++) {
            String token[] = br.readLine().split(" ");
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        visit = new boolean[T+1];
        Arrays.fill(visit, false);

        BFS(1);

        System.out.println(count-1);
    }

    public static void BFS(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visit[V] = true;
        while (!q.isEmpty()){
            int x = q.poll();
            count++;
            for(int i : graph.get(x)){
                if(!visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
