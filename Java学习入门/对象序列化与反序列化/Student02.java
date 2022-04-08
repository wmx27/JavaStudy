package Java学习入门.对象序列化与反序列化;

import java.io.Serializable;

public class Student02 implements Serializable {
    private static  final long serialVersionUID=42L;
    private String name;
    private transient int age;
    public Student02(){
    }
    public Student02(String name,int age){
        this.age=age;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
