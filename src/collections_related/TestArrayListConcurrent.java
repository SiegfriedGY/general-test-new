package collections_related;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Siegfried GENG
 * @date 2019/8/31 - 22:23
 */
public class TestArrayListConcurrent {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            new Thread( ()->{
                strList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(strList);
                System.out.println("啊啊啊啊");
            }, String.valueOf(i)).start();
        }
    }
}
