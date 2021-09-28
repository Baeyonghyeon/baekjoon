package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baek_15650 {
    public static int N;    // 정적변수로 변경
    public static int M;    // 정적변수로 변경
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> arylist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token[] = br.readLine().split(" ");
        // 정적변수 N과 M을 초기화해준다.
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);

        arr = new int[M]; // 2
        visit = new boolean[N]; // 3
        arylist = new ArrayList<>();
        // 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
        dfs(0);
        Collections.sort(arylist);

        // for문을 어떻게 정리할까... 계속 걸리는데

    }

    public static void dfs(int depth){
        if(depth == M){ //2
            for(int loop : arr){
                sb.append(loop).append(" ");
            }
            sb.append("\n");
            arylist.add(Integer.parseInt(String.valueOf(sb)));
            return;
        }

        for (int i = 0; i<N; i++){ //3
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth +1);
                visit[i] = false;
            }
        }
    }

}
