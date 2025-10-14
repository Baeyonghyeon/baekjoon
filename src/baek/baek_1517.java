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
        if (end - start < 1) return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);


        // 정렬할 대상들 복사 배열에 원본값을 옮겨 담음.
        for (int i = start; i <= end; i++) {
            tmp[i] = ary[i];
        }

        // k 값은 분할 후 합칠때 사용하는 변수
        // start부터 차근차근 값을넣을거임
        int k = start;
        int index1 = start;
        int index2 = mid + 1;

        while (index1 <= mid && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                ary[k] = tmp[index2];
                count += index2 - k;
                index2++;
                k++;
            } else {
                ary[k] = tmp[index1];
                index1++;
                k++;
            }
        }

        // 한쪽 index 값들을 다 밀어 넣었다면 나머지 한쪽은 순서대로 밀어 넣기만 하면됨(이미 정렬이 되어 있으니까)
        while (index1 <= mid) {
            ary[k] = tmp[index1];
            index1++;
            k++;
        }

        while (index2 <= end) {
            ary[k] = tmp[index2];
            index2++;
            k++;
        }
    }
}
