package others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Siegfried GENG
 * @date 2019/8/13 - 10:54
 */
public class TestDate {

    public static void main(String[] args) {

        long result = 1565688360000L - 1565688316890L;
        System.out.println(result / 1000);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        try {
            Date date = sdf.parse("2019-03-29 05");
            System.out.println(date.getTime());
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}
