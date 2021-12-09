package baek;

import java.util.Arrays;

public class programmers_42577 {
    public static void main(String[] args) {
        String sample[] = {"26354","24274","222","26"};
        System.out.println(solution(sample));
    }

    //효율성 실패 코드
    /*static boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length-1; i++) {
            String loop = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                if (loop.startsWith(phone_book[j]) || phone_book[j].startsWith(loop)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }*/

    //sort()로 할 경우(key=len 없이) 'A','AB','B','BC'와 같이 정렬되므로 sort() 후 i와 i+1 만 비교하면 for문 한번만 쓰면 된다.
    static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }
        for(int i=0; i<phone_book.length;i++){
            System.out.println(phone_book[i]);
        }
        return answer;
    }
}
