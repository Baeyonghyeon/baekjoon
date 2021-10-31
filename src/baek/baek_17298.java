package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_17298 {
    static public Stack stack = new Stack<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ans[] = new int[N];
        int list[] = new int[N];
        String token[] = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(token[i]);
        }

        for(int i=0; i<N; i++){
            if(stack.empty()==true || list[(int) stack.peek()] >= list[i]){
                stack.push(i);
            }else if(list[i] > list[(int) stack.peek()] ){
                ans[(int) stack.pop()] = list[i];
                i--;
            }
        }
        for( Object loop : stack){
            int a = (int) loop;
            ans[a] = -1;
        }

        for( int i =0; i<ans.length; i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}
