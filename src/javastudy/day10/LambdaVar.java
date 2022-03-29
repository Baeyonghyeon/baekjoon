package javastudy.day10;

public class LambdaVar {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.test(5);
    }
}

@FunctionalInterface
interface Executable {
    void execute();
}

class Outer {
    int val = 1;
    class Inner {
        int val = 2;
        void test(int i) {
            int val = 3;  // final 을 지우면 어떻게 될까?
//            i = 4;    // 재할당하면 어떻게 될까?
//            val = 2;
            Executable f = () -> {
                System.out.println("i(parameter) : " + i);
                System.out.println("val(local-var): " + val);
                System.out.println("this.val(instance var): " + this.val);
                System.out.println("Outer.this.val(outer instance var): " + Outer.this.val);
            };
            f.execute();
        }
    }
}
