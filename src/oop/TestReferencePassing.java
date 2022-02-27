package oop;

import java.util.ArrayList;
import java.util.List;

public class TestReferencePassing {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "zhangsan"));
        studentList.add(new Student(2L, "lisi"));
        studentList.add(new Student(3L, "wangwu"));
        System.out.println(studentList);
        studentList.forEach(TestReferencePassing::processAge);
        System.out.println(studentList);
        studentList.forEach(e->e.setGender(e.getId()%2==0?'男':'女'));
        System.out.println(studentList);
    }

    /**
     * 直接把对象作为参数传递进来，进行修改属性即可，根本不用返回修改完的对象。
     * 尚医通的视频里居然还返回修改完的对象。不懂引用传递吗？
     * @param stu
     */
    private static void processAge(Student stu) {
        stu.setAge((int) stu.getId() * 2);
    }

}
