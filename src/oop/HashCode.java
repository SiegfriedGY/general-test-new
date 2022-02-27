package oop;

import java.util.Objects;

public class HashCode {

    public static void main(String[] args) {

        Long x = -1L;
        Long y = 0L;
        System.out.println(x.hashCode());
        System.out.println(y.hashCode());

        Test test1 = new Test("aaa");
        System.out.println(test1);
        test1.add();
        System.out.println(test1);

        Student student = new Student(1,"aaa",12);
        System.out.println(student);
        student.addAge();
        System.out.println(student);

        /**
         * 结论：用了哪个属性来重写h/e方法，则，若操作这个属性，对象地址值就会发生变化。
         */
    }

}

class Test {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    public void add(){
        name += ">>>>>>>>>>>>>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
