package jucdemo;

import oop.Student;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {

    public static void main(String[] args) {

        AtomicReference<Student> stuRef = new AtomicReference<>();
        Student stu1 = new Student(1L, "张三");
        stuRef.set(stu1);
        Student stu2 = new Student(2L, "李四");
        stuRef.compareAndSet(new Student(1L, "张三"), stu2);
        System.out.println(new Student(1L, "张三").equals(stu1));
        System.out.println(stuRef.get());
    }

    private void test1(){
        int a = 1;
        synchronized (TestAtomicReference.class) {
            a ++;
        }
    }
}
