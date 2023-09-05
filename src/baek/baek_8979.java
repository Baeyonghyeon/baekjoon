package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_8979 {

    static int[][] ct;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int grade = 1;
        int kk[][] = new int[1][3];

        ct = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int o = Integer.parseInt(st.nextToken());
            if (o == k) {
                kk[0][0] = Integer.parseInt(st.nextToken());
                kk[0][1] = Integer.parseInt(st.nextToken());
                kk[0][2] = Integer.parseInt(st.nextToken());
            } else {
                ct[o][0] = Integer.parseInt(st.nextToken());
                ct[o][1] = Integer.parseInt(st.nextToken());
                ct[o][2] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;


        int j = 0;
        while (!flag && j < 3){
            for (int i = 1; i <= n; i++) {
                if (kk[0][j] < ct[i][j]) {
                    grade++;
                }

                if(kk[0][j] == ct[i][j]){
                    flag = true;
                    j++;
                }
            }
        }

        System.out.println(grade);

    }
}
