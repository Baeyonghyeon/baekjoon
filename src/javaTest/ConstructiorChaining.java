package javaTest;

public class ConstructiorChaining {
    public static void main(String[] args) {
        Sample sample = new Sample(26,"sample");   //사용자는 필수항목인 이메일을 입력하지 않았다.
    }
}
//"this" 키워드는 인스턴스 자신을 가리킵니다.
//        this()는...?
//        this()는 해당 클래스 생성자를 호출할 수 있습니다.
//        그렇기에 생성자 재사용이 가능하게 된다(생성자 체이닝)
class Sample {
    int age;        // 필수정보
    String name;    // 필수정보
    String email;   // ex) 선택정보

    Sample(int age, String name) {
        this(age,name, "");
    }

    Sample(int age, String name, String email){
        this.age = age;
        this.name = name;
        this.email = email;
    }
}
