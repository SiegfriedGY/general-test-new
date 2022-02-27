package java8;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 11:37
 */
public class TestLambda2 {

    public static void main(String[] args) {
        Integer result = operation(100, (x) -> x * x);
        System.out.println(result);
        System.out.println(operationString("aaabbbccc", str -> str.toUpperCase()));
    }

    /// 注意要写一个中介方法
    static public Integer operation(Integer num, TestInterface03 testInterface03){
        return testInterface03.getValue(num);
    }

    static public String operationString(String lowCase, MyInterface myInterface){
        return myInterface.getValue(lowCase);
    }

    static public void operation3(Long l1, Long l2, MyInterface1<Long, Long> myInterface1){
        System.out.println(myInterface1.getValue(l1, l2));
    }

}
