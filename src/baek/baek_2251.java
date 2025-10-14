package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_2251 {

    private static int[] send = {2, 2, 1, 1, 0, 0};
    private static int[] receive = {0, 1, 0, 2, 1, 2};
    private static int[] rest = {1, 0, 2, 0, 2, 1};
    private static boolean[][] visit = new boolean[201][201];
    private static int[] bottle = new int[3];
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bottle[0] = Integer.parseInt(st.nextToken());
        bottle[1] = Integer.parseInt(st.nextToken());
        bottle[2] = Integer.parseInt(st.nextToken());

        BFS(new Water(0, 0));

        result.sort((o1, o2) -> o1 - o2);

        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    private static void BFS(Water firstWater) {
        Queue<Water> q = new LinkedList<>();
        q.add(firstWater);

        while (!q.isEmpty()) {
            Water water = q.poll();
            int waterA = water.a;
            int waterB = water.b;
            int waterC = bottle[2] - waterA - waterB;
            visit[waterA][waterB] = true;

            if (waterA == 0 && !result.contains(waterC)) {
                result.add(waterC);
            }

            for (int i = 0; i < 6; i++) {
                int[] next = {waterA, waterB, waterC};

                int pourAmount = Math.min(next[send[i]], bottle[receive[i]] - next[receive[i]]);

                if (pourAmount > 0) {
                    next[send[i]] -= pourAmount;
                    next[receive[i]] += pourAmount;

                    Water newWater = new Water(next[0], next[1]);

                    if (!visit[newWater.a][newWater.b]) {
                        q.offer(newWater);
                        visit[newWater.a][newWater.b] = true;
                    }
                }
            }
        }
    }

    private static class Water {
        int a;
        int b;

        public Water(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
