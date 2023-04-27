package sam;

import java.util.Arrays;

public class question1 {
    public static void main(String[] args) {
        // 입력 배열
        int[] a = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -7};
        Arrays.sort(a);

        if (a[0] * a[1] > a[a.length-2] * a[a.length-1]){
            System.out.println("두 요소는 " + a[0] + ", " + a[1]);
        } else {
            System.out.println("두 요소는 " + a[a.length-2] + " " + a[a.length-1]);
        }

        System.out.println();
    }
}
