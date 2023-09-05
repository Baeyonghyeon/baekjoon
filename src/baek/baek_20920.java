package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class baek_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            if (key.length() >= m) {
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(hashMap.keySet());

        list.sort((o1, o2) -> {
            int c1 = hashMap.get(o1);
            int c2 = hashMap.get(o2);

            if (c1 == c2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
                }
                return o2.length() - o1.length(); // 해당 단어의 길이가 길수록 앞에
            }
            return c2 - c1; // 자주 나오는 단어일수록 앞에
        });

        list.forEach(l -> sb.append(l).append("\n"));
        System.out.println(sb);
    }
}
