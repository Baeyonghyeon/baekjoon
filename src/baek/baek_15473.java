package baek;

import java.util.Scanner;

public class baek_15473 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int M = sc.nextInt();
        int[] cup = new int[4];
        cup[1]=1;
        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int temp = cup[x];
            cup[x] = cup[y];
            cup[y] = temp;
        }
        for(int i=1;i<=3;i++){
            if(cup[i]==1)
                System.out.print(i);

        }
    }
}
