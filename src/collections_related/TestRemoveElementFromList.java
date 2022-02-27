package collections_related;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Siegfried GENG
 * @date 2019/9/4 - 19:16
 */
public class TestRemoveElementFromList {

    public static void main(String[] args) {

//        test();
//        test2();

        List<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < 46; i++) {
            intArray.add(i);
        }

        System.out.println("list的初始长度为"+intArray.size() +"\n");

        for (int i = 0; i < 6; i++) {
            int count = i+1;
            Random random = new Random();
            int luckyNumber = random.nextInt(46 - i);
            System.out.println("第" + count + "次产生的数为:" + luckyNumber);

            int remove = intArray.remove(luckyNumber);

            System.out.println("第" + count + "个luckNumber为" + remove);
            System.out.println("第" + count + "次取完之后的list长度为"+intArray.size() + "\n");
        }

    }

    public static void test(){

        // 不能用数组转换成list，否则下面的操作都会报UnsupportedOperationException！
//        List<Integer> ints = Arrays.asList(new Integer[] {1,2,3,4});

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        System.out.println(ints);

        // remove(Element e)时，返回的是是否成功的boolean。
        boolean b = ints.remove(new Integer(3));
        System.out.println(b);

        // remove(int index)时，返回的是这个对象。如果index超了，就报下标越界。
        Integer integer = ints.remove(5);
        System.out.println(integer);

    }

    public static void test2(){

        List<CommonBean> beans = new ArrayList<>();
        beans.add(new CommonBean(1,"zhangsan"));
        beans.add(new CommonBean(2,"lisi"));
        beans.add(new CommonBean(3,"wangwu"));
        beans.add(new CommonBean(4,"zhaoliu"));

        // 对于remove(int index)方法，要么返回正常的对象，如果下标越界，就报下标越界异常。
        CommonBean bean = beans.remove(3);
        System.out.println(bean.toString());
        System.out.println(beans);

        // 对于remove(E e)方法，当取到的时候返回true，没有取到的时候返回false，
        // 至于判断是否为同一个，当然是用equals()方法，自不待言。
        boolean zhangsan = beans.remove(new CommonBean(5, "zhangsan"));
        System.out.println(zhangsan);
    }


}
