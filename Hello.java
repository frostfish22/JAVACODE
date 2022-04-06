import java.awt.*;

import javax.swing.JFrame;
public class Hello{
    public static void main(String args[]){
        System.out.println("Hello World!!");
        Student student = new Student();
        System.out.println(student.age);
    }
    
}
class Student{
    int age;
    int height;
    int weight;
    Student(){
        this.age=0;
        this.height=0;
        this.weight=0;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}