package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baek_23305 {
    private static HashMap<Integer, Integer> ary1 = new HashMap();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ary2 = new int[N];

        String token1[] = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            int value = Integer.parseInt(token1[j]);
            if (ary1.get(value) != null) {
                ary1.put(value, ary1.get(value) + 1);
            }else{
                ary1.put(value, 1);
            }
        }
        String token2[] = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            ary2[j] = (Integer.parseInt(token2[j]));
        }

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(token2[i]);
            if(ary1.get(value) != null && ary1.get(value) != 0){
                ary1.put(value, ary1.get(value) - 1);
            }else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
