package javaStudy.day4.oop14;

public class OuterClass {
    String outerField = "외부 멤버 변수";
    static String staticOuterField = "외부 클래스 변수";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // System.out.println(outerField); // 컴파일 오류
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        //innerclass 는 outerclass 생겨야 객체가 생겨난다.
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);
    }
}

