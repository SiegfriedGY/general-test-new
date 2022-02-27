package collections_related;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionShuffle {

    public static void main(String[] args){

        List<Integer> ints = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9});
        System.out.println(ints);
        Collections.shuffle(ints);
        System.out.println(ints);
    }

}
