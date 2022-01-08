package baek;

import java.util.Scanner;

public class baek_1085 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x, y, w, h, save;
        x = scan.nextInt();
        y = scan.nextInt();
        w = scan.nextInt();
        h = scan.nextInt();

        if(x<w){
            save = w-x;
            if(save < x){
                x = save;
            }
        } else{
            save = x-w;
            if(save < x){
                x = save;
            }
        }

        if(y<h){
            save = h-y;
            if(save < y){
                y = save;
            }
        } else{
            save = y-h;
            if(save < y){
                y = save;
            }
        }

        if(x<y){
            System.out.println(x);
        } else{
            System.out.println(y);
        }
    }
}
