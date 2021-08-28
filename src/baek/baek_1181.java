package baek;

import java.util.*;

public class baek_1181 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cnt = Integer.parseInt(scan.nextLine());
        String ary[] = new String[cnt]; //입력받은 배열
        ArrayList<String> arylsit = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            ary[i] = scan.nextLine();
        }

        Arrays.sort(ary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    //compareTo()를 사용해 사전순서대로 정렬가능하다. 같은 문자열이 있으면 같은 문자 차이만큼 값이 리턴 하지만 아예 다르면 아스키 값차이로 리턴
                    // o1 = abc, o2 =b 이면 a와 b를 아스키 값으로 비교해서 뺀다 즉 97 - 98
                    //return 값은 -1이 된다.
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });


        for (String loop : ary){
            if(!arylsit.contains(loop)){ // contatins를 활용해 Arraylist안에 중복값을 받지 않음
                arylsit.add(loop);
            }
        }

        for (String loop : arylsit){
            String output = loop;
            System.out.println(output);
        }

    }
}