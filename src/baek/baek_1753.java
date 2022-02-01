package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek_1753 {
    static int V, E;
    static ArrayList<info> [] Map;
    static int [] Distance;
    static int Start;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Map = new ArrayList[V+1];
        Distance = new int[V+1];
        for(int i=0; i<=V; i++){
            Map[i] = new ArrayList<>();
            Distance[i] = INF;
        }

        Start = Integer.parseInt(br.readLine());

        int u,v,w;
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            Map[u].add(new info(v,w));
        }

        findShortestPath(Start);

        for(int i=1 ;i<=V; i++){
            if(Distance[i] != INF) sb.append(Distance[i]).append("\n");
            else sb.append("INF").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void findShortestPath(int start){
        PriorityQueue<info> pq = new PriorityQueue<>();
        Distance[start] = 0;
        pq.add(new info(start, 0));

        while (pq.isEmpty() == false){
            info now = pq.poll();

            if(now.distance > Distance[now.node]) continue;

            for(info next : Map[now.node]){
                if(Distance[next.node] > Distance[now.node] + next.distance){
                    Distance[next.node] = Distance[now.node] + next.distance;
                    pq.add(new info(next.node, Distance[next.node]));
                }
            }
        }
    }

    static class info implements Comparable<info>{
        int node;
        int distance;

        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }
}
