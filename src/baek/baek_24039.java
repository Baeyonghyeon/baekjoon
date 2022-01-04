package baek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_24039 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int i = 2;
        int value;
        while (true) {
            Boolean bl = true;

            if (i == 1) bl = false;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    bl = false;
                    break;
                }
            }

            if (bl == true) list.add(i);

            if (list.size() == 2){
                value = list.get(0) * list.get(1);
                if(value > N){
                    break;
                }else{
                    list.remove(0);
                }
            }

            i++;
        }

        System.out.println(value);

    }

}
