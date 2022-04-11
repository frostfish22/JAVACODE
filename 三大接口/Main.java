package 三大接口;
//比较器
//Comparable接口的操作
public class Main{
    
}
class Student implements Comparable<Student>{
    public int age;
    public String name;
    public double score;
    public Student(int age, String name, double score){
        this.name = name;
        this.score = score;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Student [age=" + age + ", name=" + name + ", score="+score+"]";
    }
    @Override
    //谁调用谁就是this
    public int compareTo(Student o){
        return o.name.compareTo(name);
    }
}