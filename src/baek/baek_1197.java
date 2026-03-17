package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1197 {
    private static int[] set;
    private static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Edge[] graph = new Edge[e];
        set = new int[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[i] = new Edge(a, b, c);
        }

        for (int i = 1; i <= v; i++) {
            set[i] = i;
        }

        Arrays.sort(graph);

        for (Edge edge : graph) {
            union(edge);
        }

        System.out.println(result);
    }

    private static void union(Edge edge) {
        int findA = find(edge.start);
        int findB = find(edge.end);

        if (findA != findB) { // 사이클 발생
            set[findB] = findA;
            result += edge.weight;
        }
    }

    private static int find(int a) {
        if (set[a] == a) {
            return a;
        } else {
            return set[a] = find(set[a]); // find 문제 해결 시 효율성 강화
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
