package javastudy.day6;

public class ToString {
    public static void main(String[] args) {
        Person2 p1 = new Person2("hong", 180);
        System.out.println(p1);
    }
}
class Person2 {
    String name;
    int height;
    public Person2(String name, int height) {
        this.name = name;
        this.height = height;
    }


    // ✰toString 은 확인이나 디버깅 용도로만 사용할 것.
    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
