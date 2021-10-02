package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");

        int N = Integer.parseInt(token[0]);
        int L = Integer.parseInt(token[1]);
        int D = Integer.parseInt(token[2]);

        int totaltime = N*L + N*2;

        int i=1;
        int DD;
        while (true){
            DD = D*i;
            if(L*i<= D  && L*i+5>D ){
                System.out.println(DD);
                break;
            }else if(L*i >= totaltime){
                System.out.println(DD);
                break;
            }
            i++;
            System.out.println(DD);
        }
    }
}
