package coplet;

import java.util.Arrays;

public class GraphGeneratePractice {


    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });
        for (int[] loop : output1) {
            System.out.println(Arrays.toString(loop));
        }

        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });
        for (int[] loop : output2) {
            System.out.println(Arrays.toString(loop));
        }
    }

    public static int[][] createMatrix(int[][] edges) {
        int max = maxValue(edges);
        int[][] graph = new int[max][max];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 0);
        }


        for (int i = 0; i < edges.length; i++) {
            int y = edges[i][0];
            int x = edges[i][1];
            int direction = edges[i][2];

            if (direction == 0) {
                graph[y][x] = 1;
            } else {
                graph[y][x] = 1;
                graph[x][y] = 1;
            }

        }


        return graph;
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
