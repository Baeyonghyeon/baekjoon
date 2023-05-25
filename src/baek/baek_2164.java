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
        // -> LinkedList 를 사용하면 시간초과 없이 구현 가능합니다.

        while (true) {
            if (queue.size() == 1){
                break;
            }
            cnt++;
            queue.add(queue.get(cnt++));
            System.out.println(queue);
            if (queue.size() - 1 == cnt) break;
        }

        System.out.println(queue.get(cnt));
    }
}
