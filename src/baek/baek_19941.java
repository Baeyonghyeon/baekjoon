package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_19941 {
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < n && !visit[j] && str.charAt(j) == 'H') {
                        count++;
                        visit[j] = true;
                        break;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(visit));

        System.out.println(count);
    }
}
