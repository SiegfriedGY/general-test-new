package basics;

public class OtherBasicsTest {

    private void doSomething() {

    }

    public static void main(String[] args) {
        Double x=1.2;
        long l = 1L;
        float f = (float) (x/l);
        System.out.println(f);

        String s = "hello";
        double db = 232323232;
        Double db1 = 213231123D;

        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'} ;
        System.out.println("a" + '\u0000'+ 'b'); // char的默认值是一个空格
        System.out.println(t.equals(c));
        System.out.println(100.0D % 3.0D);
        System.out.println(2/3);
        int a = 10;
        int b = 0;
//        int c;
//        float f = 48;
//        char s = '\u0639';
//        System.out.println(s);
        System.out.println("123123123123123" + " s instanceof Object " + s instanceof Object);
        String str = "hello,world\0";
        System.out.println("str: " +str);

//        System.out.println(c);
//        if (a > 50) {
//            b = 9;
//        }
//        c = b + a;

        Double d = 100D;
        Test test = new Test();
//        test.a = 9;
//        System.out.println(test.a);
        test.b = 10;
        System.out.println(test.b);
        test.b = 10;
        Integer integer1 = new Integer(9);
        Integer integer2 = new Integer(9);
        Long long1 = new Long(9);
        System.out.println(integer1.equals(long1));

    }
}

class Test {
    private int a;
    public int b;
}
