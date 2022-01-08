package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class baek_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        int N = Integer.parseInt(bf.readLine());
        int num[] = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
