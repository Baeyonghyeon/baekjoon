package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baek_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list); //컬렉션을 사용하면 Timsort를 사용한다(합병정렬 + 삽입정렬)

        for(int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
