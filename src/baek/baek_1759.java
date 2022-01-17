package baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1759 {
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static String ary[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.setIn(new FileInputStream("경로"));
        String token[] = br.readLine().split(" ");
        L = Integer.parseInt(token[0]);    //조합
        C = Integer.parseInt(token[1]);    //알파벳 개수
        ary = br.readLine().split(" ");
        Arrays.sort(ary);
        //System.out.println(Arrays.toString(ary));

        dfs(0, 0, 0, -1, "");

        System.out.println(sb);
    }

    public static void dfs(int length, int ja, int mo, int current, String pwd) {
        //1. 체크인 - 생략가능
        //2. 목적지인가? - L길이 + 자음, 모음 개수
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                sb.append(pwd).append("\n");
            }
        }
        //3. 연결된 곳은 순회 - 나보다 높은 알파벳
        else {
            for (int nextIndex = current + 1; nextIndex < ary.length; nextIndex++) {
                String next = ary[nextIndex];
                //4. 갈 수 있는가? - 생략 가능
                if (next.equals("a") || next.equals("e")|| next.equals("i") || next.equals("o") || next.equals("u")) {
                    //5. 간다 - dfs(nextData) -> 모음
                    dfs(length + 1, ja, mo + 1, nextIndex, pwd + ary[nextIndex]);
                } else {
                    //5. 간다 - dfs(nextData) -> 자음
                    dfs(length + 1, ja + 1, mo, nextIndex, pwd + ary[nextIndex]);
                }
            }
        }
        //체크 아웃
    }
}