package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_7510 {
    public static int ary[] = new int[3];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n; i++){
            String token[] = br.readLine().split(" ");
            for(int j =0; j<3; j++ ){
                ary[j] = (int) Math.pow(Integer.parseInt(token[j]), 2);
            }
            Arrays.sort(ary);

            if (ary[0] + ary[1] == ary[2]){
                sb.append("Scenario #").append((i+1)+":").append("\n").append("yes").append("\n");
            }else{
                sb.append("Scenario #").append((i+1)+":").append("\n").append("no").append("\n");
            }

            if(i<n-1) sb.append("\n");
        }

        System.out.println(sb);

    }
}
