package java8;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {

    public static void main(String[] args){

        List<Student> students = new LinkedList<>();
        students.add(new Student(1,"aaa", "男"));

        students.add(new Student(3,"ccc", "男"));
        students.add(new Student(2,"bbb", "女"));

        students.add(new Student(5,"eee", "女"));
        students.add(new Student(4,"ddd", "女"));

        List<Student> collect = students.parallelStream().filter(student -> student.getId() > 5).collect(Collectors.toList());
        // 如果一个都没有，返回的是一个size为零的空集合，而不是null！！！
        System.out.println(collect.toString());
        System.out.println(collect.size());

        String ids = students.parallelStream().map(e -> String.valueOf(e.getId())).collect(Collectors.joining(","));
        System.out.println("ids===" + ids);

        String names = students.parallelStream().map(Student::getName).collect(Collectors.joining(","));
//        names = "'" +names + "'";
//        String sql = "' and cid in (" + names + ") group by time(1d) fill(0)";
        System.out.println(names);

        int maxId = students.stream().sorted((x, y) -> y.getId()-x.getId()).collect(Collectors.toList()).get(0).getId();
        System.out.println(maxId);
        maxId = students.stream().map(Student::getId).sorted((x, y) -> y - x).collect(Collectors.toList()).get(0);
        System.out.println(maxId);
        maxId = students.stream().max(Comparator.comparingInt(Student::getId)).get().getId();
        System.out.println(maxId);

        List<StudentWithLongId> students2 = new ArrayList<>();
        students2.add(new StudentWithLongId(1L,"aaa", 11));
        students2.add(new StudentWithLongId(3L,"ccc", 22));
        students2.add(new StudentWithLongId(2L,"bbb", 33));
        students2.add(new StudentWithLongId(5L,"eee", 44));
        students2.add(new StudentWithLongId(7L,"ddd", 55));
        long maxId2 = students2.stream().max(Comparator.comparingLong(StudentWithLongId::getId)).get().getId();
        System.out.println("---------"+maxId2);
        System.out.println(students2);
        students2.parallelStream().forEach(e -> e.setName(e.getName().concat("啊")));
        System.out.println(students2);
    }
}
