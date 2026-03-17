package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class baek_18352 {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] visitCount;
    private static boolean[] visit;
    private static int n;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // node 개수
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        visitCount = new int[n + 1];
        visit = new boolean[n + 1];


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> node = graph.get(Integer.parseInt(st.nextToken()));
            node.add(Integer.valueOf(st.nextToken()));
        }

        BFS(x, k);

        Collections.sort(result);


        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (Integer i : result) {
                System.out.println(i);
            }
        }

    }

    private static void BFS(int startNode, int targetDistance) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);


        while (!q.isEmpty()) {
            int getNode = q.poll();
            List<Integer> getNodes = graph.get(getNode);
            visit[startNode] = true;

            for (Integer node : getNodes) {
                if (visitCount[node] == 0 && !visit[node]) {
                    visitCount[node] = visitCount[getNode] + 1;

                    if (visitCount[getNode] + 1 == targetDistance) {
                        result.add(node);
                    } else if (visitCount[getNode] + 1 < targetDistance) {
                        q.offer(node);
                    }
                }
            }
        }
    }
}
