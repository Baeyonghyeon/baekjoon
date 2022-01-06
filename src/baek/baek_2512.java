package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String token[] = br.readLine().split(" ");
        int list[] = new int[N];
        int min = 0;
        int mid = 0;
        int max = 0;
        int list_total = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(token[i]);
            list_total += list[i];
            if(max < list[i]) max = list[i];
        }
        int M = Integer.parseInt(br.readLine());

        if(list_total <= M){
            System.out.println(max);
        }else{
            int ans = 0;
            while (true){
                mid = (max + min) /2;
                list_total = 0;
                if(mid == min){
                    break;
                }

                for(int i=0; i<N; i++){
                    list_total += (mid < list[i]) ? mid : list[i];
                }

                if(list_total <= M){
                    ans = Math.max(mid, ans);
                    min = mid;
                }else {
                    max = mid;
                }
            }
            System.out.println(ans);
        }
    }
}
