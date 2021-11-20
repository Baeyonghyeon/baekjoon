package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[6];
        int[] full = {1, 1, 2, 2, 2, 8};
        for(int i =0; i<6;i++){
            cnt[i] = Integer.parseInt(br.readLine());
        }
        for(int i =0; i<full.length; i++){
            cnt[i] = full[i] - cnt[i];
            System.out.println(cnt[i]);
        }
    }
}
