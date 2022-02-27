package string_and_char_related;

import com.sun.deploy.util.StringUtils;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenateString {


    private static long startTimeStamp;
    private static long endTimeStamp;

    private static String startTime;
    private static String endTime;

    static {
        startTimeStamp = 1573747200;
        endTimeStamp = 1584870400;
        startTime = Instant.ofEpochSecond(startTimeStamp).toString();
        endTime = Instant.ofEpochSecond(endTimeStamp).toString();
    }
    
    public static void main(String[] args){

        System.out.println(Integer.parseInt(""));

//        String campusIdsInStr = getCampusIdsInStr();
//        System.out.println("===="+ campusIdsInStr +"====");
//        testSQL5(null);
//        testSet();
//        System.out.println(testSQL2().length());
        convert(20191204);
    }

    public static void convert(int src){

        String dateStr = String.valueOf(src);
        String dest = dateStr.substring(0,4).concat("-").concat(dateStr.substring(4,6)).concat("-").concat(dateStr.substring(6));
        System.out.println(dest);

    }

    public static String getCampusIdsInStr(){
        List<String> campusIds = Arrays.asList(new String[]{"19","29","39"});
        StringBuilder sb = new StringBuilder();
        for (String campusId : campusIds) {
            sb.append(" or cid = '").append(campusId).append("'");
        }
        return sb.toString().substring(4);
    }


    public static String testSQL(){

        String measurement = "StatPoint";
        String dimension = "active";
        String startTime = "2019-11-21T16:00:00Z";
        String endTime = "2019-11-25T16:00:00Z";
        String campusIds = "cid = '19' or cid = '18'";

        String sql = "select sum(max) as val from (select max(val) from " + measurement + " where action='" + dimension + "' and time > '" + startTime + "' and time <= '" + endTime
                + "' and (" + campusIds + ") group by time(1d), *) where action='" + dimension + "' and time > '" + startTime + "' and time <= '" + endTime + "' group by time(1d)";
        return sql;
    }

    public static String testSQL2(){

//        long startTimeStamp = 1573747200;
//        long endTimeStamp = 1574870400;
//
//        String startTime = Instant.ofEpochSecond(startTimeStamp).toString();
//        String endTime = Instant.ofEpochSecond(endTimeStamp).toString();
        String sql = "select sum(val) as val from StatLiskKickPoint where time > '" + startTime + "' and time < '" + endTime + "' and cid='" + 19
                + "' group by fullName limit 10 offset " + (1-1)*10;
        return sql;
    }

    public static String testSQL3(){

        String cids = "19,20";

        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT m.username")
                .append(" FROM manager m JOIN manager_campus mc ON m.id = mc.manager_id JOIN campus c ON mc.campus_id = c.id")
                .append(" WHERE c.id IN (")
                .append(cids).append(")");

        return sql.toString();
    }

    public static void testSet(){
        Set<String> sss = new HashSet<>();
        sss.add("123");
        sss.add("456");
        System.out.println(StringUtils.join(sss,","));
        System.out.println("===="+sss.toString()+"====");
    }

    public static void testSQL4(){

        String campusId = "18";
        String fullName = "te";
        int count = 13;
        int page = 0;

        String sqlResult = "select top(count,fullName," + count + ") as val, max as timeLong" +
                " from (select max(timeLong),count(timeLong) from StatListKickPoint" +
                " where time > '" + startTime + "' and time < '" + endTime + "' and cid='" + campusId +
                "' and fullName =~/" + fullName + "/ group by fullName)";
        System.out.println(sqlResult);
    }

    public static void testSQL5(String fullNameParam){

        String fullName = "";
        if (fullNameParam!=null && !fullNameParam.equals("")){
            fullName = fullNameParam;
        }
        long campusId = 18;
        int page = 0;
        int startDateNum = 20191201;
        int endDateNum = 20191205;

        StringBuffer buffer = new StringBuffer();

        buffer.append("SELECT kc.full_name, SUM(kc.count) AS sum, MAX(kc.date_num) FROM kick_count kc");
        buffer.append(" WHERE kc.cid=").append(campusId);
        buffer.append(" AND kc.date_num BETWEEN ").append(startDateNum).append(" AND ").append(endDateNum);
        if (fullName != null && !"".equals(fullName)){
            buffer.append(" AND full_name LIKE '%").append(fullName).append("%'");
        }
        buffer.append(" GROUP BY full_name ORDER BY sum DESC LIMIT ");
        buffer.append(page).append(", 10");

        System.out.println(buffer.toString());
    }

}
