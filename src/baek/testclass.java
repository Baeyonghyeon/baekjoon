package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testclass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 10;
        double b = 10.1;

        if(a>b){
            System.out.println("a가 더 크다");
        }else{
            System.out.println("b가더 크다");
        }

    }

}