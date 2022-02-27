package others;

import collections_related.Student;

public class TestFinal {

    public static void main(String[] args){

        final int a = 1;
        //        a = 2;
        final char[] chars = {'a','a','a','a','a','a'};
//        chars = new char[]{'x','y','z'};    // 对于引用变量，final的效果是，其作为引用，不能指向新的对象。
        chars[0] = 'b'; // 但是其指向的对象本身是可以改的。
        System.out.println(chars);

        final Student student = new Student(1L, "zhangsan", 3);
        student.setAge(5);  // 对于引用类型，final指的是引用地址不可变，而指向的那个对象完全可以改变。
        System.out.println(student);
//        student = new Student(2L, "zhangsan", 3);

        final String str = "abc";
        str.concat("123");
        System.out.println(str);    // String当然不可变
    }
}
