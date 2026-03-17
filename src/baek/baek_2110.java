package baek;

import java.io.*;
import java.util.*;

public class baek_2110 {

    static int n, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1];
        int result = Integer.MAX_VALUE;

        while (right >= left) {
            int count = 1;
            int savePoint = 0;
            int midDist = (right + left) / 2;

            for (int i = 1; i < n; i++) {
                if ((arr[i] - arr[savePoint]) >= midDist) {
                    savePoint = i;
                    count++;
                }
            }

            if (count < c) {
                right = midDist - 1;
            } else {
                result = midDist;
                left = midDist + 1;
            }
        }

        System.out.println(result);
    }
}
