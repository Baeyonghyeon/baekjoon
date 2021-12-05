package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1924 {
    public static int daysInMonth[]=  {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String dayOfTheWeeks[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int month = Integer.parseInt(token[0]);
        int day = Integer.parseInt(token[1]);
        int totalDays = day;

        for (int i = 0; i < month - 1; ++i) {
            totalDays += daysInMonth[i];
        }

        System.out.println(dayOfTheWeeks[totalDays % 7]);
    }
}
