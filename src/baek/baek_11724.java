package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baek_11724 {
    static int N, M, count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);     //node
        M = Integer.parseInt(token[1]);     //edge
        visit = new boolean[N+1];

        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<M; i++){
            token = br.readLine().split(" ");
            graph.get(Integer.parseInt(token[0])).add(Integer.valueOf(token[1]));
            graph.get(Integer.parseInt(token[1])).add(Integer.valueOf(token[0]));
        }

        for(int i=1; i<N+1; i++){
            if(graph.get(i).size() >= 0 && !visit[i]){
                BFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while (!q.isEmpty()){
            x = q.poll();
            visit[x] = true;

            for(int i : graph.get(x)){
                if(!visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
