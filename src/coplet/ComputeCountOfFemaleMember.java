package coplet;

import java.util.Arrays;
import java.util.List;

public class ComputeCountOfFemaleMember {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("coding", "Female"),
                new Member("hacker", "Male"),
                new Member("cocodoc", "Female")
        );

        int femaleCount = (int) members.stream()
                .filter(m -> m.getGender().equals("Female"))
                .count();

        System.out.println(femaleCount);
    }
}

class Member {
    String name;
    String gender;

    public Member(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
