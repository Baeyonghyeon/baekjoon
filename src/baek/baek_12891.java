package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_12891 {

    static int[] cnt = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String[] DNA = br.readLine().split("");
        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = P - 1;
        int result = 0;

        for (int i = 0; i <= end; i++) {
            if (DNA[i].equals("A")) {
                cnt[0]++;
            }
            if (DNA[i].equals("C")) {
                cnt[1]++;
            }
            if (DNA[i].equals("G")) {
                cnt[2]++;
            }
            if (DNA[i].equals("T")) {
                cnt[3]++;
            }
        }

        if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T) {
            result++;
        }

        while (true) {
            start++;
            end++;
            if (end >= S) break;

            remove(DNA[start - 1]);
            add(DNA[end]);

            if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void add(String a) {
        if (a.equals("A")) {
            cnt[0]++;
        }
        if (a.equals("C")) {
            cnt[1]++;
        }
        if (a.equals("G")) {
            cnt[2]++;
        }
        if (a.equals("T")) {
            cnt[3]++;
        }
    }

    private static void remove(String a) {
        if (a.equals("A")) {
            cnt[0]--;
        }
        if (a.equals("C")) {
            cnt[1]--;
        }
        if (a.equals("G")) {
            cnt[2]--;
        }
        if (a.equals("T")) {
            cnt[3]--;
        }
    }
}
