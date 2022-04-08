package Chapter9;

public class Rectangle {
    double width=1.0;
    double height=1.0;
    public Rectangle()
    {}
    public Rectangle(double width,double height)
    {
        this.height=height;
        this.width=width;
    }
    public double getArea()
    {
        return this.height*this.width;
    }
    public double getPerimeter()
    {
        return 2*(this.width+this.height);
    }

    public static void main(String[] args) {
        Rectangle text1=new Rectangle(3.5,35.9);
        System.out.println("宽"+text1.width+" 高"+text1.height+" 面积"+text1.getArea()+" 周长"+text1.getPerimeter());
        Rectangle text2=new Rectangle(4,40);
        System.out.println("宽"+text2.width+" 高"+text2.height+" 面积"+text2.getArea()+" 周长"+text2.getPerimeter());
    }

}
