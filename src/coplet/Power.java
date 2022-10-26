package coplet;

public class Power {
    public static void main(String[] args) {
        long output = power(3, 40);
        System.out.println(output); // --> 19334827
    }

    public static long power(int base, int exponent) {
        if (base == 0) {
            return 1;
        }

        if (exponent == 0) {
            return 1;
        }

        long halfExponent = power(base, exponent / 2);

        if ((exponent % 2) == 0) {
            return (halfExponent * halfExponent) % 94906249L;
        } else {
            return (halfExponent * halfExponent * base) % 94906249L;
        }
    }
}
