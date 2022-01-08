package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baek_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int map[][] = new int[count][2];

        for (int i = 0; i < count; i++) {                    //행
            String token[] = bf.readLine().split(" ");    //한 줄을 읽어와서 count칸짜리 배열에 삽입

            for (int j = 0; j < 2; j++) {                //열
                map[i][j] = Integer.parseInt(token[j]);          //해당 배열의 0~1번째 인덱스 값을 처리
            }
        }
        //sort 참고 https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#sort(T%5B%5D,java.util.Comparator)
        //Comparotor 파라미터로 넘어온 c의 비교 기준을 갖고 파라미터로 넘어온 객체배열 a을 정렬
        //음수일 경우 두 원소 위치교환 x , 양수일 경우 교환 o
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) { //만약 첫번째 비교값이 같다면
                    return o1[1] - o2[1]; // 두번째값을 비교해 오름차순으로 정렬한다.
                } else{
                    return o1[0] - o2[0]; // 같지않으면 오름차순으로 정렬함.
                }
            }
        });

        for(int i = 0; i < count; i++) {
            System.out.println(map[i][0] + " " + map[i][1]);
        }
    }
}
