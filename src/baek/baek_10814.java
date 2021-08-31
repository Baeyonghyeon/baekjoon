package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baek_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String user[][] = new String[count][2]; //회원 나이, 이름

        for (int i = 0; i < count; i++) {
            String token[] = bf.readLine().split(" ");    //한 줄을 읽어와서 count칸짜리 배열에 삽입

            for (int j = 0; j < 2; j++) {
                user[i][j] = String.valueOf(token[j]);          //해당 배열의 0~1번째 인덱스 값을 처리
            }
        }

        Arrays.sort(user, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int change1 = Integer.valueOf(String.valueOf(o1[0]));
                int change2 = Integer.valueOf(String.valueOf(o2[0]));
                if (change2 == change1) {
                    return 0;
                } else {
                    return change1 - change2;
                }
            }
        });

        for(int i = 0; i < count; i++) {
            System.out.println(user[i][0] + " " + user[i][1]);
        }
    }
}
