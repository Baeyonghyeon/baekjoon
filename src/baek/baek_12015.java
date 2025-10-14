package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_12015 {

    static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp.add(Integer.valueOf(st.nextToken()));
        for (int i = 1; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (dp.get(dp.size() - 1) < value) {
                dp.add(value);
            } else if (dp.get(dp.size() - 1) > value) {
                int index = binarySearch(dp, 0, dp.size(), value);
                dp.set(index, value);
            }
        }

        System.out.println(dp.size());
    }

    private static int binarySearch(List<Integer> dp, int start, int end, int value) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (dp.get(mid) < value) start = mid + 1;
            else end = mid;
        }

        return end;
    }
}
