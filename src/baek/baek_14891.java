package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baek_14891 {
    public static ArrayList<Integer>[] gear = new ArrayList[5];
    public static int gear_direction[] = new int[4];     // 1 : 오른쪽 회전, -1 : 왼쪽 회전, 0 : 회전x
    public static boolean lately[] = new boolean[4];     // flase : 무회전, true : 회전
    public static int score = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //톱니 4개 입력
        for (int i = 0; i < 4; i++) {
            gear[i] = new ArrayList<>();
            String token[] = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i].add(Integer.parseInt(token[j]));
            }
        }
        //회전 입력값
        int K = Integer.parseInt(br.readLine());              //회전 횟수
        for (int i = 0; i < K; i++) {
            Arrays.fill(gear_direction, 0);               //회전 방향 초기화
            Arrays.fill(lately, false);                   //회전할지 의사결정
            String token[] = br.readLine().split(" ");
            int gear_num = Integer.parseInt(token[0]) - 1;    //기어 숫자
            int direction = Integer.parseInt(token[1]);       //회전 방향

            gear_direction[gear_num] = direction;
            lately[gear_num] = true;
            right(gear_num);
            left(gear_num);

            for (int j = 0; j < 4; j++) {
                if (gear_direction[j] == 1) {
                    rightTurn(j);
                } else if (gear_direction[j] == -1) {
                    leftTurn(j);
                } else {
                    continue;
                }
            }

        }
        sumScore();
        System.out.print(score);


    }

    //왼쪽 기어랑 비교
    static void left(int gear_num) {
        if (gear_num == 0) return;

        if (gear[gear_num - 1].get(2) != gear[gear_num].get(6) && lately[gear_num] == true) {
            if (gear_direction[gear_num] == 1) {
                gear_direction[gear_num - 1] = -1;
            } else {
                gear_direction[gear_num - 1] = 1;
            }
            lately[gear_num-1] = true;
            left(gear_num - 1);
        }
    }

    //오른쪽 기어랑 비교
    static void right(int gear_num) {
        if (gear_num == 3) return;

        if (gear[gear_num].get(2) != gear[gear_num + 1].get(6) && lately[gear_num] == true) {
            if (gear_direction[gear_num] == 1) {
                gear_direction[gear_num + 1] = -1;
            } else {
                gear_direction[gear_num + 1] = 1;
            }
            lately[gear_num+1] = true;
            right(gear_num + 1);
        }
    }

    //반시계 방향 회전 (-1)
    static void leftTurn(int i) {
        gear[i].add(gear[i].get(0));
        gear[i].remove(0);
    }

    //시계 방향 회전 (1)
    static void rightTurn(int i) {
        gear[i].add(0, gear[i].get(7));
        gear[i].remove(8);
    }

    //최종 점수 계산
    static void sumScore(){
        for(int i = 0; i<4; i++){
            score += gear[i].get(0) * (1<<i);
        }
    }
}
