package coplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeAverageOfMaleMember {

    public static void main(String[] args) {
        Member1 coding = new Member1("coding", "Female", 25);
        Member1 hacker = new Member1("hacker", "Male", 30);
        Member1 ingi = new Member1("ingi", "Male", 32);

        List<Member1> members = Arrays.asList(coding, hacker, ingi);
        double output = computeAverageOfMaleMember(members);
        System.out.println(output); // --> 31.0

    }

    public static double computeAverageOfMaleMember(List<Member1> members) {
        //구현된 Member 클래스의 getName(), getGender(), getAge() 메소드로 해당 Member 클래스의 name, gender, age를 확인할 수 있습니다.
        //TODO..
        return members.stream()
                .filter(g -> g.getGender().equals("Male"))
                .mapToInt(Member1::getAge)
                .average()
                .orElse(0.0);

    }


}

class Member1 {
    String name;
    String gender;
    int age;

    public Member1(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
