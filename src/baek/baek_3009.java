package baek;

import java.util.Scanner;

public class baek_3009 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x,y;

        //배열값을 0으로 초기화
        int[] cnt = new int[1001];
        for(int i=0; i<cnt.length; i++){
            cnt[i] = 0;
        }
        //배열값을 0으로 초기화
        int[] cnt2 = new int[1001];
        for(int i=0; i<cnt2.length; i++){
            cnt2[i] = 0;
        }

        for(int i=0; i<3; i++){
            x = scan.nextInt();
            y = scan.nextInt();

            cnt[x]++;
            cnt2[y]++;
        }

        for(int i=0; i<cnt.length; i++){
            if(cnt[i]==1){
                System.out.print(i+" ");
            }
        }
        for(int i=0; i<cnt2.length; i++){
            if(cnt2[i]==1){
                System.out.println(i);
            }
        }
    }
}
