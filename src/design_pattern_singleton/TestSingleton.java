package design_pattern_singleton;

/**
 * @author Siegfried GENG
 * @date 2019/8/5 - 16:56
 */
public class TestSingleton {

    public static void main(String[] args) {

        Person p = Person.getPersonInstance();
        Person p1 = Person.getPersonInstance();
        System.out.println(p == p1);

//        for (int i = 0; i < 30; i++) {
//            System.out.println(Person.getPersonInstance());
//        }

        for (int i = 0; i < 10000; i++) {
            new Thread(() ->{
                System.out.println(Person.getPersonInstance());
            }).start();
        }

        Singleton2 singleton2 = Singleton2.SINGLETON_2;
        System.out.println(singleton2.hashCode());

    }

}

class Person{

//    private static singleton_related.Person person = new singleton_related.Person();

    private volatile static Person person;

    private Person(){
    }

//    public static singleton_related.Person getPerson(){
//        return person;
//    }

    public static Person getPersonInstance(){

        // 采用DCL机制，两次判断，保证万无一失
        if (person == null) {
            synchronized (TestSingleton.class){
                if (person == null){
                    person = new Person();
                }
            }
        }
        return person;
    }


}
