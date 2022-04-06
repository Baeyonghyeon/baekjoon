package java.javastudy.day1;

public class Variables {
    String instanceVariable = "instance";
    static String CLASS_VARIABLE = "class";

    public static void main(String[] args) {
        System.out.println(Variables.CLASS_VARIABLE);
        Variables vars = new Variables();
        System.out.println(vars.instanceVariable);
        vars.someMethod("parameter");
    }

    //자바는 call by value 만 있다.
    public void someMethod(String parameter) {
        String localVariable = "local";
        System.out.println("parameter: " + parameter);
        System.out.println("localVariable: "+ localVariable);
    }
}
