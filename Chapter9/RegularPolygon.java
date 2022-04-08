package Chapter9;

public class RegularPolygon {
    private int n=3;
    private double side=1;
    private double x=0;
    private double y=0;
    public RegularPolygon()
    {}
    public RegularPolygon(int n,double side)
    {
        this.n=n;
        this.side=side;
    }
    public RegularPolygon(int n,double side,double x,double y)
    {
        this.n=n;
        this.side=side;
        this.x=x;
        this.y=y;
    }
    public double getPerimeter()
    {
        return this.side*this.n;
    }
    public double getArea()
    {
        return this.n*this.side*this.side/4/Math.tan(Math.PI/this.n);
    }

    public static void main(String[] args) {
        RegularPolygon r1=new RegularPolygon();
        System.out.println("周长"+r1.getPerimeter()+"面积"+r1.getArea());
        RegularPolygon r2=new RegularPolygon(6,4);
        System.out.println("周长"+r2.getPerimeter()+"面积"+r2.getArea());
        RegularPolygon r3=new RegularPolygon(10,4,5.6,7.8);
        System.out.println("周长"+r3.getPerimeter()+"面积"+r3.getArea());
    }
}
