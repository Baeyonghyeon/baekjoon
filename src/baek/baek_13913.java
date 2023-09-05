package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_13913 {

    static int[] visit = new int[100001];
    static int[] map = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BFS(N);

        System.out.println(map[K]);
        System.out.println(visit[K]);
    }

    public static void BFS(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            N = q.poll();
            visit[N]++;
            int dx[] = {-1, 1, 2 * N};

            for (int i = 0; i < 3; i++) {
                int ix;
                if (i == 2) {
                    ix = dx[i];
                } else {
                    ix = N + dx[i];
                }

                if (ix >= 0 && ix < 100001) {
                    if (visit[ix] == 0) {
                        q.offer(ix);
                    } else if (visit[ix] != 0) {
                        if(map[ix] >= map[N]) {
                            q.offer(ix);
                            visit[ix]++;
                        }
                    }


                    map[ix] = map[N] + 1;
                }
            }
        }
    }
}
