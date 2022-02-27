package java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 21:28
 */
public class TestStreamAPI2 {

    public static void main(String[] args) {

        List<Student> students = new LinkedList<>();
        students.add(new Student(1,"张三", "男"));
        students.add(new Student(2,"李四", "女"));
        students.add(new Student(3,"王五", "男"));
        students.add(new Student(4,"赵六", "女"));
        students.add(new Student(5,"田七", "女"));
        students.add(new Student(6,"田七", "女"));


        Student student = students.stream().filter((e) -> "李四".equals(e.getName()))
                .collect(Collectors.toList()).get(0);
        System.out.println(student);

        // 注意toCollection方法的的参数！！
        // sequential()方法是把并行流切换为串行流。
        HashSet<String> collect = students.parallelStream().sequential().map(Student::getName).
                collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect);

        // 分组
        Map<String, List<Student>> groupCollect = students.stream().collect(Collectors.groupingBy(Student::getGender));
        System.out.println(groupCollect);

        // 分区，返回的是true一个分区，false一个分区
        Map<Boolean, List<Student>> partitionCollect = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getId() > 2));
        System.out.println("partitionCollect:" + partitionCollect);

        Map<Boolean, List<Student>> partitionCollect2 = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGender().equals("男")));
        System.out.println("partitionCollect2:" + partitionCollect2);

        Optional<Student> optional = students.stream().findAny();
        Student student1 = optional.get();
        System.out.println("student1:" + student1);

//        System.out.println(students);


    }

}

class Student{
    private int id;
    private String name;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}