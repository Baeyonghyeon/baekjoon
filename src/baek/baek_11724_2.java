package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11724_2 {

    static ArrayList<Integer>[] arrayLists;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //node
        int M = Integer.parseInt(st.nextToken()); //edge
        arrayLists = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int token1 = Integer.parseInt(st.nextToken());
            int token2 = Integer.parseInt(st.nextToken());

            arrayLists[token1].add(token2);
            arrayLists[token2].add(token1);
        }

        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int node) {
        if (visit[node]) {
            return;
        }

        visit[node] = true;

        for (int loop : arrayLists[node]) {
            DFS(loop);
        }
    }
}
