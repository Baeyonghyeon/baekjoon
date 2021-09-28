package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_4949 {

    public static Stack<Character> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while (true){
            String token = br.readLine();

            if(token.equals(".")){
                break;
            }
            sb.append(parenthesis(token)).append("\n");
        }


        System.out.println(sb);
    }

    public static String parenthesis(String token) {

        stack.clear();

        for (int j = 0; j < token.length(); j++) {
            if (token.charAt(j) == '(' || token.charAt(j) == '[') {
                stack.push(token.charAt(j));
            } else if (token.charAt(j) == ')') {
                if (stack.empty() == false && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return ("no");
                }
            } else if (token.charAt(j) == ']') {
                if (stack.empty() == false && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return ("no");
                }
            } else {
                continue;
            }
        }

        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }

}
