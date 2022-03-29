package javastudy.day4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 회원가입과로그인2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        boolean bl = false;

        while (!bl) {
            System.out.println("NHN Academy 에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("0. 종료");
            System.out.print("> ");
            int n = sc.nextInt();
            if (n == 1) {
                insertConsole(memberRepository);
            } else if (n == 2) {
                login(memberRepository);
            } else if (n == 0) {
                System.out.println("종료를 선택하셨습니다. 서비스를 종료합니다.");
                bl = true;
            } else {
                System.out.println("존재하지 않은 메뉴입니다. 다시 선택해 주세요.");
            }
        }
    }

    static void insertConsole(MemberRepository memberRepository) {
        System.out.println("회원가입을 해주세요.");
        System.out.print("아이디 > ");
        String id = sc.next();
        System.out.print("비밀번호 > ");
        String pw = sc.next();
        System.out.print("비밀번호 재입력 > ");
        String rpw = sc.next();
        System.out.print("이름 > ");
        String name = sc.next();

        if (!pw.equals(rpw)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
        } else if (id.length() == 0 || pw.length() == 0 || name.length() == 0) {
            System.out.println("빈칸이 존재합니다.");
        } else if (memberRepository.idDoubleCheck(id)) {
            System.out.println("아이디가 존재합니다.");
        } else {
            memberRepository.insertMember(id, pw, name);
            System.out.println("회원가입에 성공했습니다.");
        }
    }

    static void login(MemberRepository memberRepository) {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 > ");
        String id = sc.nextLine();
        System.out.print("비밀번호 > ");
        String pw = sc.nextLine();

        if (memberRepository.signIn(id, pw)){
            System.out.println("[" + memberRepository.findName(id) + "]님 환영합니다.");
        }else{
            System.out.println("아이디 혹은 비밀번호가 틀렸습니다. (다시 로그인 해주세요)");
            //System.out.println("현재 로그인을 " + memberRepository.d + "번 실패했습니다.");
        }
    }
}

class Member {
    String id;
    String pw;
    String name;

    Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    int loginAttempt = 0;

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public int getLoginAttempt() {
        return loginAttempt;
    }

}

class MemberRepository{
    List<Member> list = new ArrayList<>();

    MemberRepository() {
        list.add(new Member("qwe123", "1234", "푸석"));
        list.add(new Member("qqq111", "1111", "석푸"));
    }

    boolean idDoubleCheck(String id) {
        return list.contains(id);
    }

    void insertMember(String id, String pw, String name) {
        list.add(new Member(id, pw, name));
    }

    boolean signIn(String id, String pw) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
                return true;
            }
        }
        return false;
    }

    String findName(String id){
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
               name = list.get(i).getName();
            }
        }
        return name;
    }
}