package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_2164 {
    public static int cnt = 0;
    public static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(i + 1); //1부터 N까지 push
        }

        //문제처럼 진행한다면 N의 범위가 너무 넓기 때문에 인덱스를 당기다보면 시간초과가 난다.
        //cnt를 사용해 인덱스를 당기지 않고 구현하였다. 하지만 아래처럼 구현한다면 메모리를 많이 사용하게 된다.
        while (true) {
            if (queue.size() == 1){
                break;
            }
            cnt++;
            queue.add(queue.get(cnt++));
            if (queue.size() - 1 == cnt) break;
        }

        System.out.println(queue.get(cnt));
    }
}
