package javastudy.day3;

public class Constructor {
    public static void main(String[] args) {
        Dog snoopy = new Dog();     // !
        Cat tom = new Cat();        // OK
    }
}

class Cat {
    //기본 생성자 선언
    public Cat() {

    }
}

class Dog {
    public Dog(){

    }
}

