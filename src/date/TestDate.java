package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args){

//        long time = System.currentTimeMillis()*1000L;
//        String format = "yyyy-MM-dd";
//        System.out.println(isTodayByTimeStamp(time, format));

//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date);
//        java.sql.Date transDate = new java.sql.Date(date.getTime());
//        System.out.println(transDate);
//
//        Date date2 = new Date(1575356159L*1000);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(sdf.format(date2));

//        Random random = new Random();
//        int dateNum = 20191201 + random.nextInt(10);
//        System.out.println(dateNum);

        System.out.println(dateFormatString(new Date(), "yyyyMMdd"));
        String yyyyMMdd = dateFormatString(new Date(System.currentTimeMillis() - 30L * 24 * 3600 * 1000), "yyyyMMdd");
        System.out.println(yyyyMMdd);
        System.out.println(Integer.valueOf(yyyyMMdd).getClass());


    }

    public static boolean isTodayByTimeStamp(long timeStamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);//这个是你要转成后的时间的格式
        System.out.println(sdf.format(new Date(timeStamp)).toString());
        System.out.println(sdf.format(new Date()).toString());
        if (sdf.format(new Date(timeStamp)).toString().equals(sdf.format(new Date()).toString())) {//格式化为相同格式
            return true;
        } else {
            return false;
        }
    }

    public static Date stringFormatDate(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateFormatString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date).toString();
    }
}
