package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_12891 {

    static int[] excludePassword;
    static int[] current;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        excludePassword = new int[4];
        current = new int[4];
        Queue<String> queue = new LinkedList<>();
        String[] input = br.readLine().split("");
        st = new StringTokenizer(br.readLine());
        int count = 0;

        excludePassword[0] = Integer.parseInt(st.nextToken());
        excludePassword[1] = Integer.parseInt(st.nextToken());
        excludePassword[2] = Integer.parseInt(st.nextToken());
        excludePassword[3] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < S; i++) {
            if (queue.size() < P) {
                queue.offer(input[i]);
                sumCalc(input[i]);
            } else {
                if (current[0] >= excludePassword[0] && current[1] >= excludePassword[1] && current[2] >= excludePassword[2] && current[3] >= excludePassword[3]) {
                    count++;
                }
                String output = queue.poll();
                subCalc(output);
                queue.offer(input[i]);
                sumCalc(input[i]);
            }

        }
        if (current[0] >= excludePassword[0] && current[1] >= excludePassword[1] && current[2] >= excludePassword[2] && current[3] >= excludePassword[3]) {
            count++;
        }

        System.out.println(count);
    }

    private static void sumCalc(String value) {
        if (Objects.equals(value, "A")) current[0]++;
        if (Objects.equals(value, "C")) current[1]++;
        if (Objects.equals(value, "G")) current[2]++;
        if (Objects.equals(value, "T")) current[3]++;
    }

    private static void subCalc(String value) {
        if (Objects.equals(value, "A")) current[0]--;
        if (Objects.equals(value, "C")) current[1]--;
        if (Objects.equals(value, "G")) current[2]--;
        if (Objects.equals(value, "T")) current[3]--;
    }
}
