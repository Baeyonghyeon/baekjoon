package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2003 {
    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());

        }
        //System.out.println(Arrays.toString(nums));

        int low =0, high = 0, sum = nums[0], count = 0;

        while (true){
            //sum == M -> 답 low++
            if(sum == M){
                count++;
                sum -= nums[low++];
            }
            //sum > M -> low++
            else if(sum > M){
                sum -= nums[low++];
            }
            //sum < N -> high
            else {
                sum += nums[++high];
            }

            if(high == N){
                break;
            }
        }

        System.out.println(count);
    }
}
