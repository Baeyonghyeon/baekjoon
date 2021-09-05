package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int list[] = new int[2];
        int newslist[] = new int[5];

        //상근이
        String token[] = br.readLine().split(" ");
        for(int i = 0; i<token.length; i++){
            list[i] = Integer.parseInt(token[i]);
        }
        int listtotal = list[0] * list[1];

        //뉴스
        String newstoken[] = br.readLine().split(" ");
        for(int i = 0; i<newstoken.length; i++){
            newslist[i] = Integer.parseInt(newstoken[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i<newslist.length; i++){
            sb.append(newslist[i] - listtotal).append(" ");
        }

        System.out.println(sb);

    }
}
