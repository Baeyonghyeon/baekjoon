package javaStudy.day5.execise;

public class InsufficientFunds extends IllegalArgumentException{
    public InsufficientFunds(String s) {
        super(s);
    }
}
