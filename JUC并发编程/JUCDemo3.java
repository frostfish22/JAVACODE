package JUC并发编程;

import java.util.concurrent.atomic.AtomicReference;

class Member{
    private String name;
    private int age;
    public Member(){};
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }public void setName(String name) {
        this.name = name;
    }public int getAge() {
        return age;
    }public String getName() {
        return name;
    }@Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
public class JUCDemo3 {
    public static void main(String[] args) {
        Member memA = new Member("mldn",12);
        Member menB = new Member("小李老师",18);
        AtomicReference<Member> ref = new AtomicReference<Member>(memA);
        ref.compareAndSet(memA, menB);
        System.out.println(ref.get());
    }
}
