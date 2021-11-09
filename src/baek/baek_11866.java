package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baek_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        String token[] = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);
        int cnt = 0;      //cnt==K번째 차례에 값을 뽑는다.
        int listcnt = 0;  //원을 이루었기 때문에 배열 최대값 다음은 0으로 바뀐다.
        int truenum = 0;  //배열을 전체탐색해서 true일 경우 break하는것보다 truenum을 카운팅해서 N이되면 끝내게 하는게 더 빠를것이라 생각했다.

        //booelan 배열을 만들어 K번째 값 차례가 되면 해당인덱스 번호를 뽑고 true로 바꾼다
        boolean list[] = new boolean[N];
        Arrays.fill(list, false);

        while (true) {
            listcnt++;

            if (list[listcnt - 1] == false) {
                cnt++;
            }

            if (cnt == K) {
                cnt = 0;
                truenum++;
                list[listcnt - 1] = true;
                if (truenum == N) {
                    sb.append(listcnt).append(">");
                    break;
                } else {
                    sb.append(listcnt).append(", ");
                }

            }

            if (listcnt == N) {
                listcnt = 0;
            }

        }

        System.out.println(sb);

    }
}
