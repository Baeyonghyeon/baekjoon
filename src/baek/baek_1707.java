package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baek_1707 {
    static int K, V, E;
    static ArrayList<ArrayList<Integer>> graph;
    static int visit[];     //0 미방문 , 색칠(1 ,2) 총 3가지 구분
    static StringBuilder sb = new StringBuilder();
    static boolean bl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            bl = false;
            String token[] = br.readLine().split(" ");
            V = Integer.parseInt(token[0]); //정점 개수
            E = Integer.parseInt(token[1]); //간선 개수
            visit = new int[V + 1];
            graph = new ArrayList<>();
            for (int i = 0; i < V + 1; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                token = br.readLine().split(" ");
                graph.get(Integer.parseInt(token[0])).add(Integer.parseInt(token[1]));
                graph.get(Integer.parseInt(token[1])).add(Integer.parseInt(token[0]));
            }

            for(int i=0; i<V+1; i++){
                if(visit[i] == 0 && graph.get(i).size() > 0){
                    //System.out.println("first BFS : "+i);
                    BFS(i);
                }
            }

//            for(int i=0; i<visit.length; i++){
//                System.out.println("visit["+i+"] = "+ visit[i]);
//            }

            if (bl) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = 1;

        while (!q.isEmpty()) {
            x = q.poll();
            for (int i : graph.get(x)) {
                if (visit[i] == 0) {
                    if (visit[x] == 1) {
                        visit[i] = 2;
                    } else if (visit[x] == 2) {
                        visit[i] = 1;
                    }
                    q.offer(i);
                }else if (visit[i] != 0 && visit[i] == visit[x]){
                    bl = true;
                }
            }
        }
    }
}
