//package javaTest;
//
//public class JavaTest {
//    public static void main(String[] args) {
////        Sample sample = new Sample(26,"sample");   //사용자는 필수항목인 이메일을 입력하지 않았다.
//
//    }
//
//
//}
////"this" 키워드는 인스턴스 자신을 가리킵니다.
//
////        this()는...?
////        this()는 해당 클래스 생성자를 호출할 수 있습니다.
////        그렇기에 생성자 재사용이 가능하게 된다(생성자 체이닝)
////class Sample {
////    int age;
////    String name;
////    String email;          //선택정보
////
////    Sample(int age, String name) {
////        this(age,name, "");
////    }
////
////    Sample(int age, String name, String email){
////        this.age = age;
////        this.name = name;
////        this.email = email;
////    }
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//public class Point {
//    int x;
//    int y;
//    int z;
//
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    Point(int x, int y, int z) {
//        this(x, y);
//        this.z = z;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//abstract class 추상클래스{
//    String name = "코코용";
//
//}
//
//class 자식클래스 extends Sample {
//    @Override
//    public void print() {
//        System.out.println("나는 자식!");
//    }
//}
//
//interface run{
//
//    int MAX_SPEED = 30;
//    void fly();
//}
//
//interface roll extends run{
//    default void roll(){
//        System.out.println("구른다!");
//    }
//}
//
//class Hummingbird implements roll{
//    String name = "허밍이";
//
//    @Override
//    public void fly() {
//    }
//
//    @Override
//    public void roll() {
//    }
//}