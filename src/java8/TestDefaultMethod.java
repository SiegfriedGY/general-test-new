package java8;

/**
 * @author Siegfried GENG
 * @date 2019/8/5 - 15:11
 */
public class TestDefaultMethod {
    
    public static void main(String[] args) {
        MyInterfaceImplement implement = new MyInterfaceImplement();
        System.out.println(implement.testDefault());
        System.out.println(MyInterface.testStatic());
    }
}

class MyInterfaceImplement implements MyInterface{
    @Override
    public String getValue(String str) {
        return null;
    }

    /// 如果实现了，就调用实现的，如果没有实现，就用接口中的默认方法实现！
    @Override
    public String testDefault() {
        return "这是实现！！！";
    }
}