package collections_related;

import java.util.HashMap;
import java.util.Map;

public class MapGet {
    public static void main(String[] args){
        Map<String, Boolean> flags = new HashMap<>();
        flags.put("00", false);
        flags.put("01", false);
        flags.put("02", false);

        System.out.println(flags);
        flags.put("01", true);
        System.out.println("---> " + flags);

        boolean flag = flags.get("01");
        System.out.println(flag);

        System.out.println(flags.get("xxx"));

//        boolean b = flags.get("xxx");
//        System.out.println(b);

        Map<String, String> strMap = null;
        System.out.println(strMap);
    }
}
