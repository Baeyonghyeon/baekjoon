package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_10828 {

    public static ArrayList<Integer> stack;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i =0 ; i<N; i++){
            //여기에서 스택 함수 구성이 들어감
            String token[] = br.readLine().split(" ");

            if (token[0].equals("push")){
                push(Integer.parseInt(token[1]));
            }
            else if (token[0].equals("pop")){
                sb.append(pop());
            }
            else if (token[0].equals("size")){
                sb.append(size());
            }
            else if (token[0].equals("empty")){
                sb.append(empty());
            }
            else if (token[0].equals("top")){
                sb.append(top());
            }
        }

        System.out.println(sb);
    }

    // 정수 X를 스택에 넣는 연산이다.
    public static void push (int item){
        stack.add(item);
    }

    // 스택에서 가장 위에 있는정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int pop(){
        int value = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return value;
    }

    // 스택에 들어있는 정수의 개수를 출력한다.
    public static int size(){
        return stack.size();
    }

    // 스택이 비어있으면 1, 아니면 0을 출력한다.
    public static int empty(){
        if (stack.size() == 0){
            return 1;
        } else{
            return 0;
        }
    }

    // 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int top(){
        int value = stack.get(stack.size()-1);
        if (stack.size() == 0){
            return -1;
        }else {
            return value;
        }
    }
}
