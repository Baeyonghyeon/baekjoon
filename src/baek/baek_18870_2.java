package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class baek_18870_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //개수 받고
        int inputlist[] = new int[N];
        String token[] = br.readLine().split(" ");
        for (int j = 0; j < N; j++) { // list값 받고
            inputlist[j] = Integer.parseInt(token[j]);
        }

        int sortnum[] = inputlist.clone(); //복사
        Arrays.sort(sortnum);

        HashMap<Integer, Integer> haspmap = new HashMap<>();
        int idx = 0;
        for(int i : inputlist){
            if(!haspmap.containsKey(i)) //만약 map에 이미 존재하지 않다면 인덱스 저장
                haspmap.put(i, idx++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : sortnum){
            sb.append(haspmap.get(i)).append(" ");
        }

        System.out.println(sb);

    }
}
