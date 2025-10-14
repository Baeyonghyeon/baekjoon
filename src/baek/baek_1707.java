package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1707 {

    private static List<List<Integer>> graph;
    private static boolean[] isVisit;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            isVisit = new boolean[v+1];

            for (int k = 0; k <= v; k++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());

                List<Integer> node = graph.get(Integer.parseInt(st.nextToken()));
                node.add(Integer.parseInt(st.nextToken()));
            }


        }
    }

    private static void DFS(int value) {
        List<Integer> nodes = graph.get(value);

        for (Integer node : nodes) {

        }
    }
}
