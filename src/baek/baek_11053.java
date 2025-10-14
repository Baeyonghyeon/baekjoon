package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_11053 {
    /**
     * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
     * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
     */
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int current = Integer.parseInt(st.nextToken());
        result.add(current);

        for (int i = 0; i < N-1; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(current < value) {
                result.add(value);
                current = value;
            } else if(current > value) {
                int index = binarySearch(0, result.size(), value);
                result.set(index, value);
                current = result.get(result.size() - 1);
            }

//            System.out.println(result);
        }

        System.out.println(result.size());

    }

    static int binarySearch(int start, int end, int current) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (current > result.get(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
