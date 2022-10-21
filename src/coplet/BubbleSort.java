package coplet;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] output = bubbleSort(new int[]{1, 2, 43, 100, 100, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3]
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] >= arr [j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if(swapped == false) {
                break;
            }
        }
        return arr;
    }
}
