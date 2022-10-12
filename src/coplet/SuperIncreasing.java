package coplet;

public class SuperIncreasing {
    public static void main(String[] args) {
        boolean output = superIncreasing(new int[]{1, 3, 6, 13, 54});
        System.out.println(output); // --> true

        output = superIncreasing(new int[]{1, 3, 5, 9});
        System.out.println(output); // --> false
    }

    public static boolean superIncreasing(int[] arr) {
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentSum >= arr[i]) {
                return false;
            }

            currentSum += arr[i];
        }

        return true;
    }
}
