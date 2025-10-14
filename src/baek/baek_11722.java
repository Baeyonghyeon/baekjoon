package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_11722 {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        result.add(value);

        for (int i = 0; i < N - 1; i++) {
            value = Integer.parseInt(st.nextToken());
            if (result.get(result.size() - 1) > value) {
                result.add(value);
            } else if (result.get(result.size() - 1) < value) {
                int index = binarySearch(0, result.size(), value);
                result.set(index, value);
            }
        }

//        System.out.println(result);
        System.out.println(result.size());
    }

    static int binarySearch(int start, int end, int value) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (result.get(mid) > value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
