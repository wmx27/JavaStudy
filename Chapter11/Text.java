package Chapter11;

public class Text {
    public static void main(String[] args) {
        Circle1 circle1=new Circle1();
        Circle1 circle2=new Circle1();
        System.out.println(circle1.equals(circle2));
    }
}
class Circle1{
    double radius;

    public boolean equals(Object circle){
        //这个写法将Object转换为子类 这样即重写的方法 也保证了equals意义的存在
        return this.radius== ((Circle1)circle).radius;
    }
}
