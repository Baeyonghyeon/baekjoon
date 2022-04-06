package java.javastudy.day7;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Datetest {
    public static void main(String[] args) {
        //dt();
        //cal();
        //ld();
        //lt();
        //secondplus();
        //secondminus();
        //duration();
        //period();
        //instant();
//        convert();
        format();
    }

    //요즘 느낌은 이런것.
    private static void format() {
        String input = "1980-01-01 16:16:16";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(input, formatter);
        System.out.println(date);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초 EE");
        String output = date.format(format);
        System.out.println(output);
    }

    //calendar.date를 java.tiem로 변환
    private static void convert() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        LocalDateTime dt1 = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        OffsetDateTime odt1 = OffsetDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());

        System.out.println(date + " " + date.getTimezoneOffset());
        System.out.println(cal.getTime() + " " + cal.getTimeZone().getID());
        System.out.println(dt1);
        System.out.println(odt1);
        System.out.println(zdt1);
    }

    private static void instant() {
        Instant ts = Instant.now();
        Instant ts2 = ts.plus(1, ChronoUnit.SECONDS);
        Instant ts3 = ts.plusSeconds(1L);
        //ZoneId가 아시아로 되어있나보다..
        LocalDateTime dateTime = LocalDateTime.ofInstant(ts, ZoneId.systemDefault());

        System.out.println(ts);
        System.out.println(ts2);
        System.out.println("ts2.compareTo(ts3): " + ts2.compareTo(ts3));
        System.out.println("ts2.equals(ts3): " + ts2.equals(ts3));
        System.out.println(dateTime);

    }

    private static void period() {
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = d1.plusDays(495);

        Period p = Period.between(d1, d2);
        Period pe = d1.until(d2);
        System.out.println("p.equals(pe): " + p.equals(pe));
        System.out.println(p);
        System.out.println(p.getYears() + "Y " + p.getMonths() + "M " + p.getDays() + "D ");
        System.out.println(p.toTotalMonths());

        Period p2 = p.minusDays(595);
        System.out.println(p2);
        System.out.println(p2.getYears() + "Y " + p2.getMonths() + "M " + p2.getDays() + "D ");
        System.out.println(p2.toTotalMonths());
    }

    private static void duration() {
        Instant i1 = Instant.now();
        Instant i2 = i1.plusMillis(5555600L);

        Duration d = Duration.between(i1, i2);  // LocalDateTime 등 인자로 가능
        System.out.println(d);
        System.out.println(d.getSeconds());
        System.out.println(d.toMillis());
    }

    private static void secondminus() {
        LocalDateTime dt = LocalDateTime.now();

        // 1초를 빼는 여러가지 방법
        LocalDateTime dt2 = dt.minus(1L, ChronoUnit.SECONDS);
        LocalDateTime dt3 = dt.minusSeconds(1L);
        LocalDateTime dt4 = dt.minus(Duration.ofSeconds(1));

        System.out.println(dt);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
    }

    private static void secondplus() {
        LocalDateTime dt = LocalDateTime.now();

        // 1초를 더하는 여러가지 방법
        LocalDateTime dt2 = dt.plus(1L, ChronoUnit.SECONDS);
        LocalDateTime dt3 = dt.plusSeconds(1L);
        LocalDateTime dt4 = dt.plus(Duration.ofSeconds(1));

        System.out.println(dt);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
    }

    private static void ld() {
        LocalDate nowDate = LocalDate.now();
        LocalDateTime nowDateTime = nowDate.atStartOfDay();
        LocalDateTime dt1 = nowDate.atTime(1, 2, 3);
        LocalDate dt2 = nowDate.plus(1, ChronoUnit.DAYS);
        // LocalDate dt3 = nowDate.plus(1, ChronoUnit.HOURS);   // 어떻게 될까요?

        System.out.println(nowDate);
        System.out.println(nowDateTime);
        System.out.println(dt1);
        System.out.println(dt2);
    }

    private static void lt() {
        LocalTime nowDate = LocalTime.now();
//        LocalDateTime nowDateTime = nowDate.atStartOfDay();
//        LocalDateTime dt1 = nowDate.atTime(1, 2, 3);
//        LocalDate dt2 = nowDate.plus(1, ChronoUnit.DAYS);
        // LocalDate dt3 = nowDate.plus(1, ChronoUnit.HOURS);   // 어떻게 될까요?

        System.out.println(nowDate);
//        System.out.println(nowDateTime);
//        System.out.println(dt1);
//        System.out.println(dt2);
    }

    static void dt(){
        Date date = new Date();

        System.out.println("date: " + date);
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("date: " + date.getDate());
        System.out.println("dayOfWeek: " + date.getDay());
        System.out.println("hours: " + date.getHours());
        System.out.println("minutes: " + date.getMinutes());
        System.out.println("seconds: " + date.getSeconds());

        System.out.println("date.after(new Date()): " + date.after(new Date()));
        System.out.println("date.before(new Date()): " + date.before(new Date()));
        System.out.println("date.getTime(): " + date.getTime());
        System.out.println("date.compareTo(new Date()): " + date.compareTo(new Date())); // Comparable
    }

    static void cal(){
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.FEBRUARY, 16, 20, 30, 40);
        System.out.println(cal);
        System.out.println(cal.getTime());

        System.out.println("year: " + cal.get(Calendar.YEAR));
        System.out.println("month: " + cal.get(Calendar.MONTH));
        System.out.println("date: " + cal.get(Calendar.DATE));
        System.out.println("day of year: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("day of month: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("day of week: " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("day of week in month: " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("am pm: " + cal.get(Calendar.AM_PM));
        System.out.println("hour: " + cal.get(Calendar.HOUR));
        System.out.println("minute: " + cal.get(Calendar.MINUTE));
        System.out.println("second: " + cal.get(Calendar.SECOND));
    }
}
