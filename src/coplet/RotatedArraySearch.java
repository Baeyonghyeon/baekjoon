package coplet;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output); // --> 5

        int output2 = rotatedArraySearch(new int[]{10, 11, 12, 3, 6, 7, 8, 9}, 11);
        System.out.println(output2); // --> 1
    }

    public static int rotatedArraySearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;

            if (rotated[middle] == target) {
                return middle;
            }

            if (rotated[left] < rotated[middle]) {
                // 왼쪽 절반이 정렬되어 있는 상태
                if (target < rotated[middle] && rotated[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[right] && rotated[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}
