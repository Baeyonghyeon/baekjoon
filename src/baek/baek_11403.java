package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_11403 {
    static int N;
    static int graph[][];
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(token[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(graph[j][i] == 1 && graph[i][k] == 1) graph[j][k] = 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
