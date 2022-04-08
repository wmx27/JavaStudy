package Chapter11;

public class Circle extends GeometricObject{
    private double radius;

    public Circle(){
    }
    public Circle(double radius){
        //super("sss",true);
        this.radius=radius;
    }
    public Circle(double radius,String color,boolean filled){
        this.radius=radius;
        setColor(color);
        setFilled(filled);
    }

    @Override//注意私有方法不能被重写 静态方法也不能重写
    // 如果父类中的静态方法被重新定义 那么在父类中的静态方法会被屏蔽
    public String toString() {
        return super.toString()+"\nradius is "+radius;
    }

    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    public double getDiamter(){
        return 2*radius;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }
    public void printCircle(){
        System.out.println("The circle is created "+getDateCreated()+"and the radius is "+radius);
    }
}
