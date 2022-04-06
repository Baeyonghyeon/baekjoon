package java.javastudy.day7;

import java.math.BigInteger;

public class BigFactorial {
    public static void main(String[] args) {
        BigFactorial f = new BigFactorial();
        BigInteger result = f.bigFactorial(BigInteger.valueOf(30));
        System.out.println("factorial : 30 = " + result);

    }

    private BigInteger bigFactorial(BigInteger value){
        if(value.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }else {
            return value.multiply(bigFactorial(value.subtract(BigInteger.ONE)));
        }
    }
}
