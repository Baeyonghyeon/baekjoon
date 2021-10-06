package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_1874 {

    public static Stack<Integer> stack = new Stack<>();
    private static int stackpush = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(br.readLine());
            if (token > stackpush) {
                stackinput(token);
            }else if(stack.peek() != token){
                System.out.println("NO");
                sb.setLength(0);
                break;
            }

            stack.pop();
            sb.append("-").append("\n");

        }

        System.out.println(sb);
    }

    public static void stackinput(int input) {
        for (int i = stackpush; i < input; i++) {
            stack.push(++stackpush);
            sb.append("+").append("\n");
        }
    }

}
