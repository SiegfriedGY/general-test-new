package algorithms_and_maths;

import java.util.Arrays;
import java.util.List;

/**
 * @author Siegfried GENG
 * @date 2019/8/6 - 18:58
 */
public class RoundRobin {

    private static int num = 0;
    private static int index = 0;
    private static int x = 0;

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("A","B","C");

        while(true){

            if (num<5){
                System.out.println(strings.get(index) + "：第" + ++num +"次");
            }else {
                /// 这一次不用打印，只是把index加一！
                num=0;
                index ++ ;
                if (index >= strings.size()){
                    index = 0;
                }
            }
        }

    }

}
