package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mean, median, mode, distance; //산술평균, 중앙값, 최빈값, 범위
        int N = Integer.parseInt(br.readLine());
        int list[] = new int[N];


        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        mean = meancalculate(list);
        median = mediancalculate(list);
        mode = modecalculate(list);
        distance = distancecalculate(list);
    }

    public static int meancalculate(int list[]) {
        int value = 0;
        for (int loop : list){
            value =+ loop;
        }
        return value/list.length;
    }

    public static int mediancalculate(int list[]){
        int value = list[list.length/2];
        return value;
    }

    public static int modecalculate(int list[]){ //이게 ㅁ어렵넴
        return 0;
    }

    public static int distancecalculate(int list[]){
        int max = Arrays.stream(list).max().getAsInt();
        int min = Arrays.stream(list).min().getAsInt();
        return max-min;
    }
}
