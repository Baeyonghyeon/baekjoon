package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baek_10816 {
    private static HashMap<String, Integer> list = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String token[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (list.get(token[i]) == null) {
                list.put(token[i], 1);
            } else {
                list.put(token[i], list.get(token[i]) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String token2[] = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            if(list.get(token2[i]) != null){
                sb.append(list.get(token2[i])).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
