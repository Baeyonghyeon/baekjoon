package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1021 {
    public static int queue[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];
        for(int i =0; i<N; i++){
            queue[i] = i+1;
        }

        // 큐를 구현할것임
        //
    }

}
