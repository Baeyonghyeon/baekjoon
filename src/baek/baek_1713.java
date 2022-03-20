package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class baek_1713 {
    static int N, K;
    static int inputs[];
    static Person[] people;
    static List<Person> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    //사진틀의 개수
        K = Integer.parseInt(br.readLine());    //총 추천 횟수
        people = new Person[101];

        String token[] = br.readLine().split(" ");
        for(int i=0; i<K;i++){
            int num = Integer.parseInt(token[i]);
            if(people[num] == null){
                people[num] = new Person(num, 0, 0, false);
            }
            //사진판에 있는 경우 -> count++
            if(people[num].isIn == true){
                people[num].count++;
            }else{ // 사진판에 없는 경우 -> (자리가 없는 경우 하나 골라서, 제거 후) 새 후보 추가
                 if(list.size() == N){
                     //Collections.sort(list);
                     Person p = list.remove(0);
                     list.add(people[num]);
                 }
            }

            Collections.sort(list, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return Integer.compare(o1.num, o2.num);
                }
            });
        }
    }
}

class Person{
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Person(int num, int count, int timeStamp, boolean isIn){
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }
}
