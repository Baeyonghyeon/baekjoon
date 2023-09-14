package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1167 {
    static boolean[] visit;
    static int[] distance;
    static List<List<Graph>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        visit = new boolean[v + 1];
        distance = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < v + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int vertex = Integer.parseInt(st.nextToken());
                if (vertex == -1) {
                    break;
                }
                int edge = Integer.parseInt(st.nextToken());
                list.get(a).add(new Graph(vertex, edge));
            }
        }

//        for (int i = 0; i < v + 1; i++) {
//            System.out.println(i + " " + list.get(i));
//        }

        BFS(1);

        int max = 1;
        for (int i = 2; i < v + 1; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        visit = new boolean[v + 1];
        distance = new int[v + 1];
        BFS(max);

        System.out.println(Arrays.stream(distance).max().getAsInt());

    }

    private static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visit[n] = true;

        while (!q.isEmpty()) {
//            System.out.println(Arrays.toString(distance));
            int nowNode = q.poll();
            for (Graph loop : list.get(nowNode)) {
                int vertex = loop.getVertex();
                int edge = loop.getEdge();

                if (!visit[vertex]) {
                    distance[vertex] = distance[nowNode] + edge;
                    q.offer(vertex);
                    visit[vertex] = true;
                }
            }
        }

        // list 에 담겨 있는 vertext가 visit에 false가 되어있다면 넣으면 안된다. 메소드 분리를 해야할듯.

    }

    static class Graph {
        final int vertex;
        final int edge;

        public Graph(int vertex, int edge) {
            this.vertex = vertex;
            this.edge = edge;
        }

        public int getVertex() {
            return vertex;
        }

        public int getEdge() {
            return edge;
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "vertex=" + vertex +
                    ", edge=" + edge +
                    '}';
        }
    }
}
