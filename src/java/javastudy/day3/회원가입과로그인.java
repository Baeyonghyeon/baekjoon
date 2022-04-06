package java.javastudy.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 회원가입과로그인 {
    public static void main(String[] args) {
        Membership membership = new Membership();
        membership.init();
        membership.runMembership();
    }
}

class Member {
    String id;
    String pw;
    String name;
    //int loginAttempt;

    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        //this.loginAttempt = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Membership {
    List<Member> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void init() {
        list.add(new Member("qwe123", "1234", "조던"));
        list.add(new Member("qqq111", "1111", "던조"));
    }

    public void runMembership(){
        System.out.println("NHN Academy 에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
        System.out.print("> ");
        int n = sc.nextInt();
        if( n == 1){
            joinMember();
        } else if( n == 2){
            login();
        } else if( n == 0){
            System.out.println("종료를 선택하셨습니다. 서비스를 종료합니다.");
            return;
        } else {
            System.out.println("존재하지 않은 메뉴입니다. 다시 선택해 주세요.");
            runMembership();
        }
    }

    public void login(){
        int count = 1;
        boolean bl = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 > ");
        String id = sc.nextLine();
        System.out.print("비밀번호 > ");
        String pw = sc.nextLine();

        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)){
                System.out.println("["+list.get(i).getName()+"]님 환영합니다.");
                bl = true;
            }
        }

        if(!bl) {
            System.out.println("아이디 혹은 비밀번호가 틀렸습니다. (다시 로그인 해주세요)");
            System.out.println("현재 로그인을 "+ count++ +"번 실패했습니다.");
            login();
        }

    }

    public void joinMember() {
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
        } else if (list.contains(id)) {
            System.out.println("아이디가 존재합니다.");
        } else {
            list.add(new Member(id, pw, name));
            System.out.println("회원가입에 성공했습니다.");
        }

        System.out.println("이전 메뉴로 돌아갑니다.");
        runMembership();
    }
}