package coplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphPathFind {
    static List<List<Integer>> graph;
    static int max;
    static boolean[] visit;

    public static void main(String[] args) {
        int result = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5},
        });
        System.out.println(result); // 3

        int result2 = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result2); // 2
    }

    public static int connectedVertices(int[][] edges) {
        graph = new ArrayList<>();
        max = maxValue(edges);
        visit = new boolean[max];
        int count = 1;

        for (int i = 0; i < max; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }


        DFS(0);
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == false){
                DFS(i);
                count++;
            }
        }

        return count;
    }

    public static void DFS(int v) {
        visit[v] = true;
        for(Integer i : graph.get(v)){
            if(!visit[i]) DFS(i);
        }
    }

    public static int maxValue(int[][] edges) {
        int max = 0;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] > max) max = edges[i][0];
            if (edges[i][1] > max) max = edges[i][1];
        }

        return max + 1;
    }
}
