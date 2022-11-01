package coplet;

public class Tiling {
    public static void main(String[] args) {
        int output = tiling(2);
        System.out.println(output); // --> 2

        output = tiling(4);
        System.out.println(output); // --> 5
/*
2 x 4 보드에 타일을 놓는 방법은 5가지
각 타일을 a, b, c, d로 구분

2 | a b c d
1 | a b c d
------------

2 | a a c c
1 | b b d d
------------

2 | a b c c
1 | a b d d
------------

2 | a a c d
1 | b b c d
------------

2 | a b b d
1 | a c c d
------------
*/
    }

    public static int tiling(int num) {
        int a = 1;
        int b = 2;
        int tmp;

        for (int i = 1; i < num; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }

        return a;
    }
}
