package java8;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachAndPeek {

    public static void main(String[] args) {

        List<Student> students = new LinkedList<>();
        students.add(new Student(3,"张三", "男"));
        students.add(new Student(2,"李四", "女"));
        students.add(new Student(8,"王五", "男"));
        students.add(new Student(5,"赵六", "女"));
        students.add(new Student(4,"田七", "女"));
        students.add(new Student(6,"郭八", "男"));

        System.out.println("0------" + "\n" + students);

        // 如果只是想遍历集合进行某种操作，用stream的forEach是多余的，直接用Iterable的forEach即可！
        students.stream().forEach(e -> e.setName(e.getName()+"===")); // 对原集合修改有效！
//        students.forEach(e -> e.setName(e.getName()+"==="));    // 对原集合修改有效！
        System.out.println("1------" + "\n" + students);

        // 而stream的forEach用在已经对集合进行其他流失操作之后，但缺陷是无返回值(相当于已经是终止操作)，无法再collect！
        // 对原集合修改有效，所以也不用再收集收集。
/*        students.stream()
                .filter(e -> "男".equals(e.getGender()))
                .forEach(e -> e.setName(e.getName()+"==="));
        System.out.println("2------" + "\n" + students);*/

        // 要想遍历集合进行相关操作，又想收集结果，就用peek方法！
//        List<Student> result =
//                students.stream()
////                        .filter(e -> "男".equals(e.getGender()))
//                .peek(e -> e.setName(e.getName() + "==="))  // 单纯这一步，并不修改原集合，因为是中间操作！！
////                .sorted(Comparator.comparingInt(Student::getId))
//                .collect(Collectors.toList())
//                ;

//        System.out.println("3------" + "\n" + students);
    }
}
