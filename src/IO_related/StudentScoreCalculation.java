package IO_related;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
 * 计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。
 */
public class StudentScoreCalculation {

    public static void main(String[] args){

        List<Student> students = createList();
        writeTiFile(students, "d:"+ File.separator + "stud");

    }

    public static List<Student> createList(){

        List<Student> students = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("请输入第"+(i+1)+"个学生姓名：");
            String name = scanner.nextLine();

            System.out.println("学号：");
            int id = scanner.nextInt();
            System.out.println("语文：");
            int chinese = scanner.nextInt();
            System.out.println("数学：");
            int math = scanner.nextInt();
            System.out.println("英语：");
            int english = scanner.nextInt();
            // 在nextInt和下一个nextLine之间必须有一个这个，否则下一个nextLine不执行
            scanner.nextLine();

            double avg = (chinese + english + math)/3;

            Student student = new Student(id, name, chinese, math, english, avg);
            System.out.println(student + "\n");
            students.add(student);
        }
        return students;
    }

    private static void writeTiFile(List<Student> students, String path){

        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Student student : students) {
                System.out.println(student);
                bw.write(student.getName() + "|" +student.getId() + "|"
                + student.getChinese() + "|" + student.getMath() + "|" + student.getEnglish() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }


}

class Student {

    private Integer id;
    private String name;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private double average;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Student(Integer id, String name, Integer chinese, Integer math, Integer english, double average) {
        this.id = id;
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.average = average;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", average=" + average +
                '}';
    }
}
