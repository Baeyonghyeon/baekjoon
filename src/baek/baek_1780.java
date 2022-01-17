package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baek_1780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Boolean> list = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int reject = 0;

        String token[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (list.getOrDefault(Integer.parseInt(token[i]), false)) {
                reject++;
            } else {
                list.put(Integer.parseInt(token[i]),true);
            }
        }
        System.out.println(reject);
    }
}
