package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(br.readLine());
        int t = 20;

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ary[] = new int[t];
            int n = Integer.parseInt(st.nextToken());
            int count = 0;
            
            for (int j = 0; j < t; j++) {
                ary[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < t; j++) {
                int a = ary[j];
                for (int k = j; k < t; k++) {
                    if(a > ary[k]){
                        count++;
                    }
                }
            }
            sb.append(n).append(" ");
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
