package Chapter11;

import java.sql.SQLOutput;

public class Faculty extends Employee{
    public static void main(String[] args){
        new Faculty();
    }
    public Faculty(){
        System.out.println(" (4) Performs Facultly's tasks");
    }
}

class Employee extends Person{
    public Employee(){
        this(" (2) Invoke Employee's overloaded constructor");
        System.out.println(" (3) Performs Employee's tasks");
    }
    public Employee(String s){
        System.out.println(s);
    }
}
class Person1{
    public Person1(){
        System.out.println(" (1) Performs Person's tasks");
    }
    public Person1(String s){
        System.out.println("调用Person的有参构造方法");
    }
}