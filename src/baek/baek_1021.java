package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_1021 {
    public static ArrayList<Integer> queue = new ArrayList<>();         //현재 큐
    public static ArrayList<Integer> comparelist = new ArrayList<>();   //뽑아야 하는 숫자
    public static StringBuilder sb = new StringBuilder();

    public static int leftcnt;  //왼쪽에서 시작한 카운트수
    public static int rightcnt; //오른쪽에서 시작한 카운트수
    public static int total;    //2,3번 연산거리 합산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token1[] = br.readLine().split(" ");
        String token2[] = br.readLine().split(" ");
        int N = Integer.parseInt(token1[0]);      //큐의 크기
        int M = Integer.parseInt(token1[1]);      //뽑는 숫자개수
        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }
        for (String loop : token2) {
            int lp = Integer.parseInt(loop);
            comparelist.add(lp);
        }

        for (int i=0; i<M;i++){
            left_start_count();             //왼쪽에서 시작했을때 카운트 수
            right_start_count();            //오른쪽에서 시작했을때 카운트 수
            String str = compare();    //왼쪽 오른쪽중 작은값 return
            if(str.equals("left")){    //이동
                left_move(leftcnt);
                total += leftcnt;
            }else{
                right_move(rightcnt);
                total += rightcnt;
            }
            comparelist.remove(0);
        }

        System.out.println(total);
    }

    public static void left_start_count() {
        leftcnt = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == comparelist.get(0)) {
                break;
            }
            leftcnt++;                                  //오른쪽 카운터와 다르게 옮기고 뽑지 않음
        }
    }

    public static void right_start_count() {
        rightcnt = 0;
        for (int i=queue.size()-1; i >=0 ; i--){
            rightcnt++;                                 //왼쪽에서만 뽑을 수 있으므로 옮기는 작업 횟수 추가
            if (queue.get(i) == comparelist.get(0)) {
                break;
            }

        }
    }

    //왼쪽과 오른쪽중 짧은쪽 비교
    public static String compare(){
        if (rightcnt > leftcnt) {
            return "left";
        }else{
            return "right";
        }
    }

    //왼쪽으로 옮기는 작업
    public static void left_move(int count){
        for(int i=0; i<count; i++){
            queue.add(queue.get(0));
            queue.remove(0);
        }
        queue.remove(0);
    }

    //오른쪽으로 옮기는 작업
    public static void right_move(int count){
        for(int i=0; i<count; i++){
            queue.add(0,queue.get(queue.size()-1));
            queue.remove(queue.size()-1);
        }
        queue.remove(0);
    }


}
