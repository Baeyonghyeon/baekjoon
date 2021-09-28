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
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            String token = br.readLine();
            sb.append(parenthesis(token)).append("\n");
        }

        System.out.println(sb);
    }

    public static String parenthesis(String token){

        stack.clear();

        for (int j = 0; j < token.length(); j++) {
            if (token.charAt(j) == '(') {
                stack.add(token.charAt(j));
            } else if (token.charAt(j) == ')') {
                if (stack.empty() == false) {
                    stack.pop();
                } else if (stack.empty() == true) {
                    return ("NO");
                }
            }
        }

        if (stack.empty()){
            return "YES";
        } else{
            return "NO";
        }
    }

}
