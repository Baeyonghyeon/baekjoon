import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class baek_1316 {
    private static String input;
    private static int x, cnt, chk=0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var map = new HashMap<String, Integer>(26); //알파벳 숫자변환용 해쉬
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
        map.put("g", 6);
        map.put("h", 7);
        map.put("i", 8);
        map.put("j", 9);
        map.put("k", 10);
        map.put("l", 11);
        map.put("m", 12);
        map.put("n", 13);
        map.put("o", 14);
        map.put("p", 15);
        map.put("q", 16);
        map.put("r", 17);
        map.put("s", 18);
        map.put("t", 19);
        map.put("u", 20);
        map.put("v", 21);
        map.put("w", 22);
        map.put("x", 23);
        map.put("y", 24);
        map.put("z", 25);

        x = scan.nextInt(); // 입력할 단어 개수
        int[] check = new int[26];
        for (int j = 0; j <= x; j++) {
            for (int l = 0; l < check.length; l++) { check[l] = 1; } //새 단어가 시작할때마다 1로 초기화시켜줌

            input = scan.nextLine(); // 문자 입력
            for (int i = 0; i < input.length(); i++) {

                String eng2 = Character.toString(input.charAt(i));
                int ao = map.get(eng2); // ao에 해당문자 value저장

                if (chk == ao || check[ao] == 1) { // ao가 chk랑 같거나 해당문자 배열이 1일경우 진행
                    chk = ao;
                    check[chk] = 0; //한번 사용한 문자 0으로 교체
                    if (i == input.length() - 1) { //단어가 문제없이 끝까지 진행되면 cnt++
                        cnt++;
                        break;
                    }
                } else { break; }
            }
        }
        System.out.println(cnt);
    }
}