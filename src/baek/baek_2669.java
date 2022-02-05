package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2669 {
    static boolean[][] map = new boolean[100][100];
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for( int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int j=b ; j<d; j++){
                for(int k =a; k<c;k++){
                    if(!map[j][k]){
                        map[j][k] = true;
                        value++;
                    }
                }
            }
        }
        System.out.println(value);
    }
}
