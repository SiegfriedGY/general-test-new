package oop;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();

        System.out.println(p);
        System.out.println(p1);

    }
}


class Person implements Cloneable {

    public Person(int age, String name) {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
//        return super.clone();
        return null;
    }
}
