package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class baek_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Queue<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Queue<Integer> q = new LinkedList<>();
            list.add(q);
        }




    }
}
