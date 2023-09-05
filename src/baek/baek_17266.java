package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] map = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int maxDistance = Math.max(map[0], n - map[m - 1]);

        for (int i = 1; i < m; i++) {
            if (((map[i] - map[i - 1]) & 1) == 0) {
                maxDistance = Math.max(maxDistance, ((map[i] - map[i - 1]) / 2));
            } else {
                maxDistance = Math.max(maxDistance, ((map[i] - map[i - 1]) / 2 + 1));
            }

        }

        System.out.println(maxDistance);
    }
}
