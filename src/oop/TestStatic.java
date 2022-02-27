package oop;

public class TestStatic {

    static private String str = "abc";
    static void sayHello(){
        System.out.println("hello");
    }

    public static void main(String[] args){
        TestStatic testStatic = new TestStatic();
        System.out.println(str);
        System.out.println(testStatic.str); // 实例对象可以访问静态变量
        sayHello();
        testStatic.sayHello();     // 实例对象可以调用静态方法

    }
}
