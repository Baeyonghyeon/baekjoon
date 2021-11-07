package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_18258 {
    public static ArrayList<Integer> queue = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String loop[] = br.readLine().split(" ");

            if (loop[0].equals("push")) {
                push(Integer.valueOf(loop[1]));
            } else if (loop[0].equals("pop")) {
                pop();
            } else if (loop[0].equals("size")) {
                size();
            } else if (loop[0].equals("empty")) {
                empty();
            } else if (loop[0].equals("front")) {
                front();
            } else { //back
                back();
            }
        }

        System.out.println(sb);


    }

    //정수 X를 큐에 넣는 연산이다.
    public static void push(int x) {
        queue.add(x);
    }

    //큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //pop연산을 수행할때 queue.remove(0)을 수행하게 되면 해당 인덱스를 삭제하며 뒤에값들을 한칸씩 앞으로 땡기게되는데 연산과정이 오래걸려 시간초과된다.
    public static void pop() {
        if (queue.size() - cnt == 0) {
            sb.append("-1").append("\n");
        } else {
            int value = queue.get(cnt++); //카운트를 증가시킨다. (front증가랑 같은뜻)
            sb.append(value).append("\n");
        }

    }

    //큐에 들어있는 정수의 개수를 출력한다.
    public static void size() {
        sb.append(queue.size()-cnt).append("\n");
    }

    //큐가 비어있으면 1, 아니면 0을 출력한다.
    public static void empty() {
        if (queue.size()-cnt == 0) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    //큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void front() {
        if (queue.size()-cnt == 0) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.get(cnt)).append("\n");
        }
    }

    //큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void back() {
        if (queue.size()-cnt == 0) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.get(queue.size() - 1)).append("\n");
        }
    }
}
