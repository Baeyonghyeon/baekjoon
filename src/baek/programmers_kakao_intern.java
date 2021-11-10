package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class programmers_kakao_intern {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(solution(num, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        boolean right = false;
        boolean left = false;
        for(int i =0; i<numbers.length; i++){
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "left";
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "right";
            } else {
                if(right = true){
                    answer += right;
                }
            }

            if (right == left){
                if(hand == "right"){
                    right = true;
                    answer += "R";
                }else{
                    left = true;
                    answer += "L";
                }
            }
        }


        return answer;
    }
}
