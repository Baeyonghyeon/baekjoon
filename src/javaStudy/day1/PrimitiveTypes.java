package javaStudy.day1;

public class PrimitiveTypes {

    static int intDefault;
    static byte byteDefault;
    static short shortDefault;
    static long longDefault;
    static float floatDefault;
    static double doubleDefault;
    static char charDefault;
    static boolean booleanDefault;

    public static void main(String[] args) {
        PrimitiveTypes types = new PrimitiveTypes();
        types.bytes();
        longs();
        defaultValues();
    }

    public void bytes(){
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("min byte = " + minByte);
        System.out.println("max byte = " + maxByte);
        int minByteMinus1 = (int) (minByte-1);
        int maxBytePlus1 = (int) (maxByte+1);

        //최대나 최소값에서 값을 더하거나 빼면 넘어간다(?)
        System.out.println("min byte - 1 = " + minByteMinus1);
        System.out.println("max byte + 1 = " + maxBytePlus1);
    }

    public static void longs(){
        //long 형은 _ 포함되도 괜찮다. 1000 단위로 잘라서 표현하면 가독성 굿! L을 마지막에 넣어주어야 한다.
        long total = 20323242340320230L;
        long total2 = 20_323_242_340_320_230L;

        System.out.println("total : "+ total);
        System.out.println("total2 : " + total2);
    }

    public static void defaultValues(){
        System.out.println("intDefault : " + intDefault);
        System.out.println("byteDefault: " + byteDefault);
        System.out.println("shortDefault: " + shortDefault);
        System.out.println("longDefault: " + longDefault);
        System.out.println("floatDefault: " + floatDefault);
        System.out.println("doubleDefault: " + doubleDefault);
        System.out.println("charDefault: " + charDefault + ": " + (int)charDefault); System.out.println("booleanDefault: " + booleanDefault);
    }
}
