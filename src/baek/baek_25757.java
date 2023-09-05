package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baek_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        int result = 0;

        int n = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        for (int i = 0; i < n; i++) {
            String loop = br.readLine();
            hashSet.add(loop);
        }

        if (str.equals("Y")) {
            result = hashSet.size();
        }
        if (str.equals("F")) {
            result = hashSet.size() / 2;
        }
        if (str.equals("O")) {
            result = hashSet.size() / 3;
        }

        System.out.println(result);
    }
}
