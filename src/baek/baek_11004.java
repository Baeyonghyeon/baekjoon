package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(ary, 0, N - 1, K - 1);
        System.out.println(ary[K - 1]);
    }

    private static void quickSort(int[] ary, int left, int right, int K) {
        if (left < right) {
            int pivot = partition(ary, left, right);

            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(ary, left, pivot - 1, K);
            } else {
                quickSort(ary, pivot + 1, right, K);
            }
        }
    }

    private static int partition(int[] ary, int left, int right) {
        int M = (left + right) / 2;
        swap(ary, left, M);

        int pivot = ary[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (pivot < ary[j]) {
                j--;
            }
            while (i < j && pivot >= ary[i]) {
                i++;
            }
            swap(ary, i, j);
        }

        ary[left] = ary[i];
        ary[i] = pivot;

        return i;
    }

    private static void swap(int[] ary, int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
}
