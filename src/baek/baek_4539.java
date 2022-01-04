package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_4539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-->0){
            String token[] = br.readLine().split("");
            int list[] = new int[token.length];
            Integer_change(token,list);

            if(list.length > 1){
                for(int i=list.length-1; i > 0; i--){
                    if(list[i] > 4){
                        list[i-1]++;
                        list[i] = 0;
                    }else{
                        list[i] = 0;
                    }
                }
            }

            for(int i=0; i<list.length; i++){
                sb.append(list[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[] Integer_change(String token[], int list[]){
        for(int i = 0; i<list.length; i++){
            list[i] = Integer.parseInt(token[i]);
        }
        return list;
    }
}
