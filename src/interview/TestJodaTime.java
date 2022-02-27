package interview;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import java.time.LocalDateTime;
import java.util.Date;

public class TestJodaTime {

    public static void main(String[] args) {
        LocalDate localDate1 = new LocalDate();
        System.out.println(localDate1);
        System.out.println(LocalDateTime.now().toString());
        System.out.println(java.time.LocalDateTime.now().toString());

        LocalDate localDate2 = new LocalDate();
        LocalDate localDate3 = new LocalDate(new Date());
        System.out.println("----> " + localDate1.isEqual(localDate2));
        System.out.println(localDate1.equals(localDate3));

        Date date = localDate3.toDateTimeAtStartOfDay().toDate();
        System.out.println(date + "-------------");


        // 计算之前月份的时间操作
        LocalDate d = new LocalDate();
        // 上个月(可以是之前的任意月)的最后一天
        LocalDate lastDayOfPreviousMonth = d.minusMonths(2).dayOfMonth().withMaximumValue();
        System.out.println(lastDayOfPreviousMonth);
        System.out.println(localDate2.equals(lastDayOfPreviousMonth));
        System.out.println(localDate2.isEqual(lastDayOfPreviousMonth));
    }
}
