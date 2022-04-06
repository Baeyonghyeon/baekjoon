package java.javastudy.day6;

public class Wrapper {
    public static void main(String[] args) {
        Boolean b = Boolean.valueOf(true);
        Character c = Character.valueOf('c');
        Byte bb = Byte.valueOf(Byte.MAX_VALUE);
        Short s = Short.valueOf(Short.MAX_VALUE);
        Integer i = Integer.valueOf(128);
        Long l = Long.valueOf(Long.MAX_VALUE);
        Float f = Float.valueOf(Float.MAX_VALUE);
        Double d = Double.valueOf(Double.MIN_VALUE);
    }
}
