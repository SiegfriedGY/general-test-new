package multithreading_related;

/**
 * @author Siegfried GENG
 * @date 2019/8/2 - 23:52
 */
public class TestSelfIncrement {

    static private int i =10;

    public static void main(String[] args) {

        /// 如果是i++之后打印i，是11没问题。
        /// 如果是i=i++之后打印i，则还是10，因为是三步走原理：读-改-写
//        i++;
        i = i++;

//        int j = i++;
//        System.out.println(j);
        System.out.println("i="+i);
    }

}
