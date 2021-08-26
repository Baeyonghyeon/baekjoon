package baek;

import java.util.Scanner;

public class baek_7568 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int x[] = new int[N];
        int y[] = new int[N];

        for(int i=0; i<N; i++){
            x[i] = scan.nextInt(); //몸무게
            y[i] = scan.nextInt(); //키
        }

        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j< N ; j++) {
                if (x[i] < x[j] && y[i] < y[j]) {
                    rank++;
                }
            }
            System.out.println(rank);
        }
    }
}
