package baek;

import java.io.*;
import java.util.ArrayList;

public class baek_10845 {
    static ArrayList<Integer> q = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.setIn(new FileInputStream("/Users/a000/IdeaProjects/beakjoon/src/baek/input"));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String token[] = br.readLine().split(" ");
            if (token[0].equals("push")) push(Integer.parseInt(token[1]));
            else if (token[0].equals("pop")) pop();
            else if (token[0].equals("size")) size();
            else if (token[0].equals("empty")) empty();
            else if (token[0].equals("front")) front();
            else if (token[0].equals("back")) back();
        }
    }

    public static void push(int x) {
        q.add(x);
    }

    public static void pop() {
        if(q.isEmpty()) System.out.println(-1);
        else System.out.println(q.remove(0));
    }

    public static void size() {
        System.out.println(q.size());
    }

    public static void empty() {
        if (q.isEmpty()) System.out.println(1);
        else System.out.println(0);
    }

    public static void front() {
        if (q.isEmpty()) System.out.println(-1);
        else System.out.println(q.get(0));
    }

    public static void back(){
        if(q.isEmpty()) System.out.println(-1);
        else System.out.println(q.get(q.size()-1));
    }
}
