package 三大接口;

class Person implements Cloneable {
    public int age;

    public void eat() {
        System.out.println("吃！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.age = 13;
        Person person2 = (Person) person.clone();
        System.out.println(person2);
        System.out.println(person);
        System.out.println("===========");
        person2.age = 14;
        System.out.println(person);
        System.out.println(person2);

    }
}