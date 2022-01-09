package baek;

import java.util.Scanner;

public class baek_2798 {

    static int x, y, z, total = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); //카드수
        int M = scan.nextInt(); //3장 카드합
        int card[] = new int[N]; //카드입력
        for (int i = 0; i < N; i++) {
            card[i] = scan.nextInt();
        }

        for (int i = 0; i < N - 2; i++) {
            x = card[i];
            for (int o= i+1; o < N - 1; o++) {
                y = card[o];
                for (int p= o+1 ; p < N; p++) {
                    z = card[p];
                    if (x + y + z > total && x + y + z <= M) {
                        total = x + y + z;
                    }
                }
            }
        }
        
        System.out.println(total);
    }
}
