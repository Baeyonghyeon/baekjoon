package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t[] = new int[3];
            t[0] = Integer.parseInt(st.nextToken());
            t[1] = Integer.parseInt(st.nextToken());
            t[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(t);

            if (t[0] == 0 && t[1] == 0 && t[2] == 0) {
                break;
            }

            if (t[0] + t[1] <= t[2]) {
                sb.append("Invalid");
            } else if (t[0] == t[1] && t[1] == t[2]) {
                sb.append("Equilateral");
            } else if ((t[0] == t[1]) || (t[1] == t[2]) || (t[0] == t[2])) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}

