package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String token[] = br.readLine().split(" ");
            int A = Integer.parseInt(token[0]);
            int B = Integer.parseInt(token[1]);
            System.out.println("yes");
        }

// 소인수로 풀었지만 이렇게 풀 이유가 없었다...
// A= 6*2*1*1*1 , B= 6+2+1+1+1 어거지로 끼워 맞추기 가능하다 그래서 값만 받고 yes출력하면 된다
/*        for (int i = 0; i < T; i++) {
            boolean bl = false;
            String token[] = br.readLine().split(" ");
            int A = Integer.parseInt(token[0]);
            int B = Integer.parseInt(token[1]);
            for (int j = 1; j <= A; j++) {
                if (A % j == 0) {
                    int quotient = A / j;
                    if (j + quotient == B) {
                        bl = true;
                        break;
                    }
                }
            }

            if (bl == false) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }*/
    }
}
