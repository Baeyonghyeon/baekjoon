package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] ary = new int[N];
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            int target = ary[i];
            int start = 0;
            int end = N-1;

            while (start < end) {
                if(start == i){
                    start++;
                }
                if(end == i){
                    end--;
                }
                if(start >= end){
                    break;
                }

                int sum = ary[start] + ary[end];
                if (target < sum) {
                    end--;
                } else if (target > sum) {
                    start++;
                } else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
