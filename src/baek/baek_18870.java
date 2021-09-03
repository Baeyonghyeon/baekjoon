package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class baek_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase=0;

        int N = Integer.parseInt(br.readLine()); //개수 받고
        int inputlist[] = new int[N];
        int outputlist[]= new int[N];
        int compare[] = new int[N];
        boolean bl = false;
        String token[] = br.readLine().split(" ");

        for (int j = 0; j < N; j++) { // list값 받고
            inputlist[j] = Integer.parseInt(String.valueOf(token[j]));
        }

        for(int i=0; i<N; i++){
            int count = 0;
            testcase = inputlist[i];

            for(int j =0; j<N; j++){
                if(testcase > inputlist[j]){
                    for(int k=0; k<N; k++){
                        if(compare[k] == inputlist[j]){
                            continue;
                        }else{
                            compare[k] = inputlist[j];
                            bl = true;
                        }
                    }

                    if(bl == true){
                        count++;
                        bl = false;
                    }
                }
            }
            Arrays.fill(compare, 0);
            outputlist[i] = count;
        }

        StringBuilder sb = new StringBuilder();

        for (int loop: outputlist) {
            sb.append(loop).append(" ");
        }

        System.out.println(sb);
    }

}
