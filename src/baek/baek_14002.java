package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class baek_14002 {

    static List<Integer> dp = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp.add(Integer.valueOf(st.nextToken()));
        result.add(dp.get(0));

        for (int i = 1; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (dp.get(dp.size() - 1) < value) {
                dp.add(value);
                result.add(value);
            } else if (dp.get(dp.size() - 1) > value) {
                int index = binarySearch(dp, 0, dp.size(), value);
                dp.set(index, value);
                if (result.get(index) > value) {
                    result.set(index, value);
                }
            }
        }

        System.out.println(dp.size());
        String output = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.print(output);

    }

    private static int binarySearch(List<Integer> arr, int start, int end, int value) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) < value) start = mid + 1;
            else end = mid;
        }

        return end;
    }
}
