package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class baek_baek_22232 {
    /**
     * 파일명 (FILENAME) 사전순으로
     * 파일명 (FILENAME)이 같다면 가희가 설치한 OS에서 인식하는 확장자가 붙은 것이 먼저 나오게
     * 1과 2로도 순서를 결정할 수 없다면, 파일 확장자 (EXTENSION) 사전 순으로
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> key = new HashSet<>();
        String[] list = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken();
        }
        for (int i = 0; i < m; i++) {
            key.add(br.readLine());
        }


        List<String> collect = Arrays.stream(list)
                .sorted((o1, o2) -> {
                    String a1 = o1.split("\\.")[0];
                    String a2 = o1.split("\\.")[1];
                    String b1 = o2.split("\\.")[0];
                    String b2 = o2.split("\\.")[1];

                    if (a1.equals(b1)) {//  파일명 (FILENAME)이 같다면
                        if (key.contains(a2) && key.contains(b2)) { //1과 2로도 순서를 결정할 수 없다면, 파일 확장자 (EXTENSION) 사전 순으로
                            return o1.split("\\.")[1].compareTo(o2.split("\\.")[1]);
                        } else if (key.contains(a2)) { //가희가 설치한 OS에서 인식하는 확장자가 붙은 것이 먼저 나오게
                            return o1.compareTo(o2);
                        } else {
                            return o2.compareTo(o1);
                        }
                    }

                    return o1.compareTo(o2);
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
