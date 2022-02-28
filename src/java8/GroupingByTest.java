package java8;

import collections_related.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingByTest {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"aaa", 11));
        students.add(new Student(2L,"ccc", 22));
        students.add(new Student(34L,"bbb", 33));
        students.add(new Student(31L,"bbb", 33));
        students.add(new Student(48L,"eee", 44));
        students.add(new Student(42L,"eee", 44));
        students.add(new Student(43L,"eee", 44));
        students.add(new Student(5L,"ddd", 55));

        Map<Integer, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        System.out.println(collect);

        Map<Integer, Map<Long, List<Student>>> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getAge, TreeMap::new,
                        Collectors.groupingBy(Student::getId, TreeMap::new, Collectors.toList())));
        System.out.println(collect1);

        List<Student> result = new ArrayList<>();
        for (Map<Long, List<Student>> map : collect1.values()) {
            for (List<Student> subMap : map.values()) {
                result.addAll(subMap);
            }
        }
        System.out.println(result);
    }
}
