package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_13549 {

    static boolean[] visit = new boolean[100001];
    static int[] map = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        BFS(N);

//        System.out.println(Arrays.toString(map));
        System.out.println(map[K]);
    }

    private static void BFS(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        map[N] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();
            visit[n] = true;
            int[] dx = {n * 2, -1, 1};

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = dx[i];
                } else {
                    nx = n + dx[i];
                }

                if (nx >= 0 && nx <= 100000 && !visit[nx]) {
                    q.offer(nx);
                    visit[nx] = true;

                    if (i == 0) {
                        map[nx] = map[n];
                    } else {
                        map[nx] = map[n] + 1;
                    }
                }
            }
        }
    }
}
