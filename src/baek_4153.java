import java.util.Scanner;

public class baek_4153 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x, y, z, max;

        while (true) {
            x = scan.nextInt();
            y = scan.nextInt();
            z = scan.nextInt();

            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            max = (x < y) ? (y < z) ? (max = z) : (max = y) : (x < z) ? (max = z) : (max = x);

            if (max == x) {
                x = y;
                y = z;
            } else if (max == y) {
                y = z;
            }

            if (max * max == (x * x + y * y)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}
