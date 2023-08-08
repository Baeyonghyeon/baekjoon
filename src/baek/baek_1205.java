package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int grade = 1;
        int count = 0;

        if(n != 0){
            int[] ary = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                if (ary[i] > score) {
                    grade++;
                    count++;
                } else if (ary[i] == score) {
                    count++;
                } else {
                    break;
                }
            }
        }

        if(count >= p){
            System.out.println("-1");
        } else {
            System.out.println(grade);
        }
    }
}
