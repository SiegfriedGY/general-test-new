package string_and_char_related;

import java.util.ArrayList;
import java.util.List;

public class StringListContain {
    
    public static void main(String[] args){
        
        List<String> strList = new ArrayList<>();
        strList.add("AAA");
        strList.add("BBB");
        strList.add("CCC");
        strList.add("DDD");

        System.out.println(strList);
        System.out.println(strList.contains("CCC"));

    }
}
