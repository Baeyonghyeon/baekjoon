package java.javastudy.day6;

public class speedClass {
    public static void main(String[] args) {
        //speedPrimitiveType();
        //speedPrimitiveTypeAndWrapperClass();
        //speedWrapperClass();

        int i1001_10_1 = Integer.parseInt("1001");
        int i1001_10_2 = Integer.valueOf("1001");
        int i1001_10_3 = Integer.parseInt("1001", 10);
        int i1001_10_4 = Integer.valueOf("1001", 10);
        int i1001_2_1 = Integer.parseInt("1001", 2);
        int i1001_2_2 = Integer.valueOf("1001", 2);
        int i1001_8_1 = Integer.parseInt("1001", 8);
        int i1001_8_2 = Integer.valueOf("1001", 8);
        int iAA_16_1 = Integer.parseInt("AA", 16);  // 10(A) * 16 + 10(A)
        int iAA_16_2 = Integer.parseInt("AA", 16);
//  int iAA_10 = Integer.parseInt("AA");  // 예외 발생
    }

    static void speedPrimitiveType() {
        final int COUNT = 100000;

        int[] nums = new int[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedPrimitiveType");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void speedPrimitiveTypeAndWrapperClass() {
        final int COUNT = 100000;

        Integer[] nums = new Integer[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedPrimitiveTypeAndWrapperClass");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void speedWrapperClass() {
        final int COUNT = 100000;

        Integer[] nums = new Integer[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        Integer sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedWrapperClass");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

}
