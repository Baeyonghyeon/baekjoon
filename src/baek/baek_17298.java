package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_17298 {

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] nge = new int[n];
        result = new int[n];

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nge[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || (nge[stack.peek()] > nge[i])) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    if (nge[stack.peek()] < nge[i]) {
                        int index = stack.pop();
                        result[index] = nge[i];
                    } else {
                        break;
                    }
                }
                stack.push(i);

            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == 0) sb.append(-1).append(" ");
            else sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
