package javastudy.day7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sdf {
    public static void main(String[] args) {
        //format();
        parse();
        
        
    }

    private static void parse() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String input = "1980-01-01 16:16:16";
        try {
            Date date = format.parse(input);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void format() {
        //옛날 코드를 고치게 된다면 이런 코드를 만나게 된다.
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
        System.out.println(format.format(cal.getTime()));
    }
}
