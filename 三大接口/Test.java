package 三大接口;

import java.util.Arrays;
import java.util.Comparator;

class Student {
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.score - o2.score);
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Test {
    public static void main2(String[] args) {
        Student students1 = new Student(1, "bit", 98.9);
        Student students2 = new Student(2, "abc", 88.9);
        /*
         * if(students1.compareTo( students2) > 0) {
         * }
         */
        // System.out.println(students1.compareTo( students2));
        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(students1, students2));
    }

    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student(12, "lisi", 98.9);
        student[1] = new Student(6, "zangwu", 88.9);
        student[2] = new Student(18, "whangsan", 18.9);
        System.out.println(Arrays.toString(student));
        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        NameComparator nameComparator = new NameComparator();
        Arrays.sort(student, nameComparator);// 默认是从小到大的排序
        System.out.println(Arrays.toString(student));
    }

    public static void main1(String[] args) {
        int[] array = { 1, 21, 3, 14, 5, 16 };
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}