package collections_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NullPointerWithCollection {
    
    public static void main(String[] args){
        
        List<String> stringList;

        if (3 == 3) {
            stringList = new ArrayList<>();
        } else {
            stringList = Arrays.asList(new String[]{"aaa","bbb","ccc"});
        }
        System.out.println(stringList);
                
    }
}
