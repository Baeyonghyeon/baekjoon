package javaStudy.day6;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Scanner;

public class MultiException {
    public static void main(String[] args) {
        someMethod(new String[]{"NHN", "1"});
        someMethod(new String[]{"NHN", "aaa"}); //NumberFormatException
        someMethod(new String[]{});             //ArrayIndexOutOfBoundsException
        scanMethod();
    }


    //예외에도 계층이 존재한다.
    //Exception은 모든 에러를 잡기 때문에 구체화된 오류를 먼저 작성해야 한다.
//    static void someMethod(String[] strs) {
//        int num = 0;
//        try {
//            num = Integer.parseInt(strs[1]);
//        } catch (ArrayIndexOutOfBoundsException aie) {   //배열에 해당 요소가 없을때
//            System.out.println("catch ArrayIndexOutOfBoundsException " + aie);
//        } catch (NumberFormatException nfe) {            //해당 문자열을 숫자로 변경할 수 없을 때
//            System.out.println("catch NumberFormatException " + nfe);
//        } catch (Exception e) {
//            System.out.println("catch Exception" + e);
//        }
//        System.out.println("num = " + num);
//    }

    static void someMethod(String[] strs) {
        int num = 0;
        try {
            num = Integer.parseInt(strs[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException cause) {  // !
            System.out.println("catch ArrayIndexOutOfBoundsException or NumberFormatException " + cause);
        } catch (Exception e) {
            System.out.println("catch Exception " + e);
        }
        System.out.println("num = " + num);
    }

    static void scanMethod(){
        File file = new File("/Users/a000/IdeaProjects/beakjoon/src/javaStudy/day6/SomeFile");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch(Exception cause) {
            System.err.println("스캔 실패: " + cause.getMessage());
            cause.printStackTrace();
        } finally { // !
            if (scanner != null) {
                scanner.close();    // close 할 때도 예외가 발생할 수 있어요.
            }
        }
    }
}
