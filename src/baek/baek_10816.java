package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baek_10816 {
    private static HashMap<String, Integer> list = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //숫자카드 입력
        int N = Integer.parseInt(br.readLine());
        String token[] = br.readLine().split(" ");  //상근이 입력값
        for (int i = 0; i < N; i++) {
            if (list.get(token[i]) == null) {   //hash에 key값이 없으면 넣고 value를 1로 세팅
                list.put(token[i], 1);
            } else {
                list.put(token[i], list.get(token[i]) + 1); //기존에 존재했다면 value++
            }
        }

        //숫자카드 찾기
        int M = Integer.parseInt(br.readLine());
        String token2[] = br.readLine().split(" "); //찾을 카드
        for(int i=0; i<M; i++){
            if(list.get(token2[i]) != null){
                sb.append(list.get(token2[i])).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
