package Chapter11;

public class dynamicBindingDemo {
    public static void main(String[] args) {
        //Object[] c = new int[3];
        //
        // System.out.println(c);
        m(new GraduateStudent());
        m(new Student());
        m(new Person());
        m(new Object());
    }
    public static void m(Object x){
        System.out.println(x.toString());
    }
}
class GraduateStudent extends Student{
}
class Student extends Person{
    @Override
    public String toString(){
        return "Student";
    }
}
class Person extends Object{
    @Override
    public String toString(){
        return "Person";
    }

}
