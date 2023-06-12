package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1517 {
    static int[] ary;
    static int[] tmp;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ary = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(count);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            tmp[i] = ary[i];
        }

        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                ary[k] = tmp[index2];
                count = count + index2 - k;
                k++;
                index2++;
            } else {
                ary[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= mid) {
            ary[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= end) {
            ary[k] = tmp[index2];
            k++;
            index2++;
        }
    }

}
