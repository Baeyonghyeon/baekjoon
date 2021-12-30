package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int K = Integer.parseInt(token[0]);
        int N = Integer.parseInt(token[1]);
        int list[] = new int[K];
        long min = 0;
        long max = 0;
        for (int i = 0; i < K; i++) {
            list[i] = Integer.parseInt(br.readLine());
            if (list[i] > max) max = list[i];
        }

        max++;      //ex) 동타가 나왔을때 1 1이 나오면 min<max 조건에 걸리지 않으므로 max++ 해주어야 한다.
        long key;
        long count;

        while (min < max) {
            key = (min + max) / 2;
            count = 0;

            for (int i = 0; i < K; i++) {
                count += list[i] / key;
            }

            if (count < N) {
                max = key;
            } else {
                min = key + 1;
            }
        }

        System.out.println(min - 1);

    }
}
