package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1434 {

    static int N,M;
    static int cap[], size[];

    public static void main(String[] args) throws IOException {
        //선언 및 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cap = new int[N];
        size = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            cap[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
            size[i] = Integer.parseInt(st.nextToken());

        //계산
        //int s = size[0];
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(size[i] <= cap[j]) {
                    cap[j]-=size[i];
                    break;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<N;i++)
            cnt+=cap[i];
        System.out.println(cnt);
    }
}
