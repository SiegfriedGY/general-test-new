package others;

import oop.Student;

public class ObjectInLoopTest {

    public static void main(String[] args) {

        Student student;

        for (int i = 0; i < 5; i++) {
            student = new Student((long) i, "stu" + i);
            System.out.println(student);
        }
    }
}
