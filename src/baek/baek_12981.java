package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_12981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] rgb = new int[3];
        rgb[0] = Integer.parseInt(st.nextToken());
        rgb[1] = Integer.parseInt(st.nextToken());
        rgb[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(rgb);

        int result = rgb[0];
        rgb[1] -= rgb[0];
        rgb[2] -= rgb[0];

        result += rgb[1] / 3;
        result += rgb[2] / 3;

        rgb[1] %= 3;
        rgb[2] %= 3;

        if (rgb[1] == 0 && rgb[2] == 0) {

        } else if ((rgb[1] == 1 && rgb[2] == 1) || rgb[1] == 0 || rgb[2] == 0) {
            result++;
        } else {
            result += 2;
        }

        System.out.println(result);
    }
}
