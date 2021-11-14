package baek;

import java.awt.image.TileObserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_10866 {
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> deck = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split(" ");

            if (token[0].equals("push_front")) {
                push_front(Integer.parseInt(token[1]));
            } else if (token[0].equals("push_back")) {
                push_back(Integer.parseInt(token[1]));
            } else if (token[0].equals("pop_front")) {
                pop_front();
            } else if (token[0].equals("pop_back")) {
                pop_back();
            } else if (token[0].equals("size")) {
                size();
            } else if (token[0].equals("front")) {
                front();
            } else if (token[0].equals("back")) {
                back();
            } else{
                empty();
            }
        }

        System.out.println(sb);
    }

    //정수 X를 덱의 앞에 넣는다.
    public static void push_front(int element) {
        deck.add(0,element);
    }

    //정수 X를 덱의 뒤에 넣는다.
    public static void push_back(int element) {
        deck.add(element);
    }

    //덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void pop_front() {
        int element;
        if(deck.size() == 0){
            element = -1;
        }else{
            element = deck.get(0);
            deck.remove(0);
        }
        sb.append(element).append("\n");

    }

    //덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    private static void pop_back() {
        int element;
        if(deck.size() == 0){
            element = -1;
        }else{
            element = deck.get(deck.size()-1);
            deck.remove(deck.size()-1);
        }
        sb.append(element).append("\n");

    }

    //덱에 들어있는 정수의 개수를 출력한다.
    public static void size() {
        sb.append(deck.size()).append("\n");
    }

    //덱이 비어있으면 1을, 아니면 0을 출력한다.
    private static void empty() {
        int element;
        if(deck.size() == 0){
            element = 1;
        }else{
            element = 0;
        }
        sb.append(element).append("\n");
    }

    //덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void front() {
        int element;
        if(deck.size() == 0){
            element = -1;
        }else{
            element = deck.get(0);
        }
        sb.append(element).append("\n");
    }

    //덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void back() {
        int element;
        if(deck.size() == 0){
            element = -1;
        }else{
            element = deck.get(deck.size()-1);
        }
        sb.append(element).append("\n");
    }
}