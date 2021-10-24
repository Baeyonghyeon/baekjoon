package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_22950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        int K = Integer.parseInt(br.readLine());
        int count = 0;
        int onecount = 0;

        for (int i = 0; i < N; i++) {
            if (M.charAt(i) == '0') {
                count++;
            } else if (M.charAt(i) == '1') {
                count = 0;
                onecount++;
            }
        }

        if(onecount == 0){
            System.out.println("YES");
        }
        else if (count >= K) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
