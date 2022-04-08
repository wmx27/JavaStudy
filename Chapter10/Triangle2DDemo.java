package Chapter10;


public class Triangle2DDemo {
    public static void main(String[] args) {

    }
}
class MyPoint {
    private double x;
    private double y;

    public MyPoint()
    {
        this.x=0;
        this.y=0;
    }
    public MyPoint(double x,double y)
    {
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(double x,double y)
    {
        double distance=Math.sqrt(Math.pow(Math.abs(x-this.x),2)+Math.pow(Math.abs(y-this.y),2));
        return distance;
    }
    public double distance(MyPoint p)
    {
        double distance=Math.sqrt(Math.pow(Math.abs(p.getX()-this.x),2)+Math.pow(Math.abs(p.getY()-this.y),2));
        return distance;
    }
    public static double distance(MyPoint p1,MyPoint p2)
    {
        double distance=Math.sqrt(Math.pow(Math.abs(p1.getX()- p2.getX()),2)+Math.pow(Math.abs(p1.getY()-p2.getY()),2));
        return distance;
    }

}
class Triangle2D{
     private MyPoint p1;
     private MyPoint p2;
     private MyPoint p3;

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }

    public MyPoint getP1() {
        return p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public MyPoint getP3() {
        return p3;
    }
    public Triangle2D ()
    {
        this.p1=new MyPoint(0,0);
        this.p2=new MyPoint(1,1);
        this.p3=new MyPoint(2,5);
    }
    public Triangle2D(MyPoint p1,MyPoint p2,MyPoint p3)
    {
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }
    public double getPerimeter()
    {
        double sum=p1.distance(p2)+p2.distance(p3)+p3.distance(p1);
        return sum;
    }
    public double getArea()
    {
        //已知三个点求面积公式可以写出S=(x1y2-x1y3+x2y3-x2y1+x3y1-x2y2)。
        double Area=p1.getX()*p2.getY()-p1.getX()*p3.getY()+p2.getX()*p3.getY()-p2.getX()*p1.getY()+p3.getX()*p1.getY()-p2.getX()*p2.getY();
        return Area;
    }


}

