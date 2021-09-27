package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_10773 {

    public static Stack<Integer> stack = new Stack<>();
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i =0; i<K; i++){
            int token = Integer.parseInt(br.readLine());

            if(token == 0){
                stack.pop();
            }else{
                stack.push(token);
            }
        }

        while (true){
            if(stack.empty() == false) { //스택이 비어있으면 ture
                value += stack.pop();
            }else{
                break;
            }
        }

        System.out.println(value);

    }
}
