package baek;

import java.io.*;
import java.util.StringTokenizer;

public class baek_14652 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int mysit = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(mysit==count) {
                    bw.write(i+" "+j);
                    bw.flush();
                }
                count++;
            }
        }
        bw.close();
    }
}
