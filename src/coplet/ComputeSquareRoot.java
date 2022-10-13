package coplet;

import java.text.DecimalFormat;

public class ComputeSquareRoot {
    public static void main(String[] args) {
        String output = computeSquareRoot(9);
        System.out.println(output); // --> "3.00"

        output = computeSquareRoot(6);
        System.out.println(output); // --> "2.45"
    }

    public static String computeSquareRoot(int num) {
        double x = 10;

        for (int i = 0; i < 10; i++)
            x = 0.5 * (num / x + x);

        x = Math.round(x*100)/100.0;

        DecimalFormat df = new DecimalFormat("###.00");
        return df.format(x);
    }
}
