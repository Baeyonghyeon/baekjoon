package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_5430 {
    public static int T, R, D, leftcnt, rightcnt, n;
    public static Boolean bl = false;                   //left = false, right = true
    public static Boolean errorcheck;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //R을 받으면 실제로 값을 바꾸는게 아니라 배열 시작위치를 boolean값으로 조정
        for (int i = 0; i < T; i++) {
            list.clear();
            bl = false;                                 //left = false, right = true
            errorcheck = false;                         //false = 에러없음, true = 에러
            String p = br.readLine();                   //수행할 함수
            n = Integer.parseInt(br.readLine());        //배열에 들어있는 수의 개수
            leftcnt = 0;
            rightcnt = n;
            String str = br.readLine();
            //입력받은 배열 int형으로 변환
            str = str.replaceAll("[^0-9]", " ").trim(); //0~9숫자만 남김
            String token[] = str.split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(token[j]));
            }

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R' && bl == false) {
                    bl = true;
                } else if (p.charAt(j) == 'R' && bl == true) {
                    bl = false;
                } else if (p.charAt(j) == 'D' && bl == false) {   //왼쪽 첫번째 값 삭제
                    if (rightcnt == 0 || rightcnt <= leftcnt) {
                        sb.append("error").append("\n");
                        errorcheck = true;
                        break;
                    } else {
                        leftcnt++;
                    }
                } else {                                            //오른쪽 첫번째 값 삭제
                    if (rightcnt == 0 || rightcnt <= leftcnt) {
                        sb.append("error").append("\n");
                        errorcheck = true;
                        break;
                    } else {
                        rightcnt--;
                    }
                }
            }

            if (bl == false && errorcheck == false) {
                left_read();
            } else if (bl == true && errorcheck == false) {
                right_read();
            } else {
                continue;
            }

        }

        System.out.println(sb);
    }

    public static void left_read() {
        sb.append("[");
        for (int i = leftcnt; i < rightcnt; i++) {
            if (i == rightcnt - 1) {
                sb.append(list.get(i)).append("]").append("\n");
            } else {
                sb.append(list.get(i)).append(",");
            }
        }

        if (n == 0 || rightcnt == leftcnt) {
            sb.append("]").append("\n");
        }
    }

    public static void right_read() {
        sb.append("[");
        for (int i = rightcnt - 1; i >= leftcnt; i--) {
            if (i == leftcnt) {
                sb.append(list.get(i)).append("]").append("\n");
            } else {
                sb.append(list.get(i)).append(",");
            }
        }

        if (n == 0 || rightcnt == leftcnt) {
            sb.append("]").append("\n");
        }

    }
}
