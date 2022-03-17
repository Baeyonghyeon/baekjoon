package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            String token[] = br.readLine().split(" ");
            int ary[] = new int[3];
            ary[0] = Integer.parseInt(token[0]);
            ary[1] = Integer.parseInt(token[1]);
            ary[2] = Integer.parseInt(token[2]);
            int ary2[] = ary.clone();
            Arrays.sort(ary);

            if(ary[0]+ary[1] != ary[2]){       // 조건 성립x
                sb.append("-1").append("\n");
            }else{                             // 조건 성립o
                sb.append(1+" "+1+" "+1+" "+(ary2[0]+1)+" "+(ary2[0]+1)+" "+(ary2[1]+1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
