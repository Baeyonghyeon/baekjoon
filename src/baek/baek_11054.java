package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11054 {

    static int[] seq;
    static List<Integer> rSeq;
    static List<Integer> lSeq;
    static int[] rCount;
    static int[] lCount;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        seq = new int[N];
        rSeq = new ArrayList<>();
        lSeq = new ArrayList<>();
        rCount = new int[N];
        lCount = new int[N];
        result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = (Integer.parseInt(st.nextToken()));
        }

        // 정방향
        for (int i = 0; i < N; i++) {
            if (i == 0) rSeq.add(seq[0]);
            if (rSeq.get(rSeq.size() - 1) < seq[i]) {
                rSeq.add(seq[i]);
            } else if (rSeq.get(rSeq.size() - 1) > seq[i]) {
                int index = binarySearch(rSeq, 0, rSeq.size(), seq[i]);
                rSeq.set(index, seq[i]);
            }

            rCount[i] = Math.min(rSeq.size(), seq[i]);
        }

        // 역방향
        for (int i = N - 1; i >= 0; i--) {
            if (i == N - 1) lSeq.add(seq[N - 1]);
            if (lSeq.get(lSeq.size() - 1) < seq[i]) {
                lSeq.add(seq[i]);
            } else if (lSeq.get(lSeq.size() - 1) > seq[i]) {
                int index = binarySearch(lSeq,0, lSeq.size(), seq[i]);
                lSeq.set(index, seq[i]);
            }

            lCount[i] = Math.min(lSeq.size(), seq[i]);
        }

        int maxResult = 0;
        for (int i = 0; i < N; i++) {
            maxResult = Math.max(maxResult, rCount[i] + lCount[i] - 1);
        }

//        System.out.println(rSeq);
//        System.out.println(lSeq);
//
//        System.out.println(Arrays.toString(rCount));
//        System.out.println(Arrays.toString(lCount));

        System.out.println(maxResult);

    }

    // 정방향 찾기
    private static int binarySearch(List<Integer> seq, int start, int end, int value) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (seq.get(mid) < value) start = mid + 1;
            else end = mid;
        }

        return end;
    }

//    // 역방향 찾기
//    private static int lBinarySearch(int start, int end, int value) {
//        while (start < end) {
//            int mid = (start + end) / 2;
//
//            if (lSeq.get(mid) > value) start = mid + 1;
//            else end = mid;
//        }
//
//        return end;
//    }
}
