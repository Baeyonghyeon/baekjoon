package java.javastudy.day1;

public class UnaryOperator {
    public static void main(String[] args) {
        UnaryOperator op = new UnaryOperator();
        op.unary2();
    }

    public void unary2(){
        int i = 1;
        System.out.println(i++);        //1
        System.out.println(i);          //2
        System.out.println(++i);        //3
        System.out.println("----------");
        System.out.println(--i);        //2
        System.out.println(i);          //2
        System.out.println(i--);        //2
        System.out.println(i);          //1
    }
}
