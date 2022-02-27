package collections_related;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestConcurrentModificationException {

    public static void main(String[] args){

        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        System.out.println("初始集合：" + testList);

        // 只有增强for循环才会报并发更改异常（因为内部就是Iterator来实现的）！普通for循环是不会报的！
        // 也就是：1.增强for循环（本身就是迭代器）或2.迭代器，来迭代，但删除的时候用list本身的删除，就会报！
//        for (Integer integer : testList) {
//            if (integer % 2 == 0){
//                testList.remove(integer);
//            }
//        }

        // 不能用普通for循环！虽然不报并发更改异常，但是集合的长度在不断缩短，会导致数据错乱！！！（可以倒着来）
//        for (int i = 0; i < testList.size(); i++) {
//            Integer integer = testList.get(i);
////            System.out.println("此次修改前size："+testList.size()+"，当前遍历的元素为："+ integer);
//            if (integer % 2 == 1){
//                testList.remove(integer);
//            }
////            System.out.println("此次修改后size："+testList.size());
////            System.out.println("============================");
//        }
//        System.out.println(testList);

        // 正确的有四种方式：
        // 1. 大集合减去小集合；
        // 2. 迭代器（遍历+删除）！
        // 4. Collection类的removeIf(e -> xxx)
        testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        Iterator<Integer> iterator = testList.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.println("此次修改前size："+testList.size()+"，当前遍历的元素为："+ integer);
            if (integer % 2 == 1){
                iterator.remove(); // 注意要用iterator自己的remove方法！
            }
            System.out.println("此次修改后size："+testList.size());
            System.out.println("============================");
        }
        System.out.println(testList);

        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"aaa", 11));
        students.add(new Student(2L,"ccc", 22));
        students.add(new Student(3L,"bbb", 33));
        students.add(new Student(4L,"eee", 44));
        students.add(new Student(5L,"ddd", 55));
//        removeInvalidStudents(students);
        removeIf(students);
    }

    /**
     * 这不会并发更改异常！
     * @param students
     */
    private static void removeInvalidStudents(List<Student> students){

        System.out.println("删除前："+students);
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("现在是第"+(i+1)+"个学生");
            if (student.getId() %2 ==0){
                System.out.println("此学生为偶数，删除！！！");
                students.remove(student);
            }
        }
        System.out.println("删除后："+students);
    }

    /**
     * 这就会并发更改异常！！
     * @param students
     */
    private static void removeInvalidStudents2(List<Student> students){

        System.out.println("删除前："+students);
        for (Student student : students) {
            if (student.getId() % 2 == 0){
                students.remove(student);
            }
        }
        System.out.println("删除后："+students);
    }

    private static void removeIf(List<Student> students){
        System.out.println("删除前："+students);
        students.removeIf(student -> student.getId()%2 == 0);
        System.out.println("删除后："+students);
    }

}
