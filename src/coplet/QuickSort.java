package coplet;

public class QuickSort {
    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        System.out.println(output); // --> [1, 3, 21]
    }

    public static int[] quickSort(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int pivot = arr[arr.length / 2];



        }
    }
}
