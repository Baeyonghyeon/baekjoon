package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1806 {
    static int N, S;
    static int[] nums;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low =0, high = 0, sum = nums[0];

        while (true){
            // sum >= S -> 답 list에 count 추가, low++
            if(sum >= S){
                list.add((high-low)+1);
                sum -= nums[low++];
            }
            // sum < S -> high++
            else {
                sum += nums[++high];
            }

            if(high == N){
                break;
            }
        }

        if(list.isEmpty()){
            System.out.println(0);
        }else{
            Collections.sort(list);
            System.out.println(list.get(0));
        }

    }
}
