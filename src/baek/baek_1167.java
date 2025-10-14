package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1167 {

    static List<List<int[]>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i <= v; i++) {
            List<int[]> node = new ArrayList<>();
            graph.add(node);
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            List<int[]> node = graph.get(parentNode);

            while (st.hasMoreElements()) {
                int nodeNum = Integer.parseInt(st.nextToken());
                if (nodeNum == -1) {
                    break;
                } else {
                    int direct = Integer.parseInt(st.nextToken());
                    node.add(new int[]{nodeNum, direct});
                }
            }
        }

        int maxIndex = 0;

        count = new int[v + 1];
        visit = new boolean[v + 1];

        BFS(1);

//        System.out.println("test 1 : " + Arrays.toString(count));
        for (int j = 1; j < count.length; j++) {
            if (max < count[j]) {
                max = count[j];
                maxIndex = j;
            }
        }

        count = new int[v + 1];
        visit = new boolean[v + 1];
        BFS(maxIndex);

        max = 0;
        for (int value : count) {
            max = Math.max(max, value);
        }
//        System.out.println("test 2 : " + Arrays.toString(count));

        System.out.println(max);
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            int getNode = q.poll();

            for (int[] getV : graph.get(getNode)) {
                int connectNode = getV[0];
                int distance = getV[1];

                if (!visit[connectNode]) {
                    q.offer(connectNode);
                    visit[connectNode] = true;
                    count[connectNode] = count[getNode] + distance;
                }
            }
        }

    }
}
