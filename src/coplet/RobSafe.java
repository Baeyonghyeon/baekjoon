package coplet;

public class RobSafe {
    public static void main(String[] args) {
        long output1 = ocean(50, new int[]{10, 20, 50});
        System.out.println(output1); // 4

        long output2 = ocean(100, new int[]{10, 20, 50});
        System.out.println(output2); // 10

        long output3 = ocean(30, new int[]{5, 6, 7});
        System.out.println(output3); // 4
    }

    private static long ocean(int i, int[] ints) {

        return 0;
    }
}
