package oop;

public class BaseSonTest {

    public static void main(String[] args)
    {
        Base base = new Son();
        base.method();
//        base.methodB();
    }
}
class Base
{
    public void method()
    {
        System.out.println("Base");
    }
}
class Son extends Base
{
    public void method()
    {
        System.out.println("Son");
    }

    public void methodB()
    {
        System.out.println("SonB");
    }
}
