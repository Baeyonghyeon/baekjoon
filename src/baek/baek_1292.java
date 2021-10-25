package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_1292 {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        listadd();
        String token[] = br.readLine().split(" ");
        int A = Integer.parseInt(token[0]);
        int B = Integer.parseInt(token[1]);
        int result = 0;
        for(int i=A-1; i<B; i++){
            result += list.get(i);
        }
        System.out.println(result);

    }

    static void listadd(){
        int i=1;
        while (true){
            for(int j=0; j<i; j++){
                list.add(i);
            }
            i++;
            if (list.size() > 1001) break;
        }
    }
}
