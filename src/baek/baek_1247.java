package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class baek_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger comparevalue = new BigInteger("0");
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<3; i++) {
            BigInteger total = new BigInteger("0");
            int N = Integer.parseInt(br.readLine());
            for(int j=0; j<N; j++) {
                BigInteger bigInteger = new BigInteger(br.readLine());
                total = total.add(bigInteger);
            }

            if(total.compareTo(comparevalue) == 0){ //동일
                sb.append("0").append("\n");
            }
            else if(total.compareTo(comparevalue) == -1){ //0보다 작음
                sb.append("-").append("\n");
            }
            else if(total.compareTo(comparevalue) == 1){ //0보다 큼
                sb.append("+").append("\n");
            }
        }

        System.out.println(sb);

    }
}
