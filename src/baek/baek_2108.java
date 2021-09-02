package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mean;
        int median, mode, distance; //산술평균, 중앙값, 최빈값, 범위
        int N = Integer.parseInt(br.readLine());
        int list[] = new int[N];
        int countlist[] = new int[8001]; // countlist[0 ~ 4001] : -1 ~ -4000 , countlist[4002 ~ 8001] : 0 ~ 4000

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            list[i] = input;
            //최빈값
            countlist[input+4000]++;
        }

        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();

        mean = meancalculate(list);         // 산술평균
        median = mediancalculate(list);     // 중앙값
        mode = modecalculate(countlist);    // 최빈값
        distance = distancecalculate(list); // 범위

        sb.append(mean).append('\n').append(median).append('\n').append(mode).append('\n').append(distance);
        System.out.println(sb);
    }

    public static int meancalculate(int list[]) {
        double value = 0;
        for (int loop : list){
            value += loop;
        }
        value /= list.length;
        return (int) Math.round(value);
    }

    public static int mediancalculate(int list[]){
        int value = list[list.length/2];
        return value;
    }

    public static int modecalculate(int list[]){
        int modevalue = 0;
        boolean stack = false;
        int firstchk = list[0];

        for (int i=1; i<8001; i++){ // -4000부터 검사
            if(list[i] > firstchk) { // 최빈값 가장 높은 값이 처음 걸릴때
                firstchk = list[i];
                modevalue = i;
                stack = true;
            } else if (list[i] == firstchk && stack == true) { // 현재 최빈값이랑 같은수의 최빈값이 또 걸릴때
                firstchk = list[i];
                modevalue = i;
                stack = false;
            }
        }
        return modevalue-4000;
    }

    public static int distancecalculate(int list[]){
        int max = Arrays.stream(list).max().getAsInt();
        int min = Arrays.stream(list).min().getAsInt();
        return max-min;
    }
}
