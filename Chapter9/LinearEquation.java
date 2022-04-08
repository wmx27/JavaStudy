package Chapter9;
import java.util.Scanner;

public class LinearEquation {
    private double a, b, c, d, e, f;
    public LinearEquation (double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getD() {
        return d;
    }
    public double getE() {
        return e;
    }
    public double getF() {
        return f;
    }
    public boolean isSolvable(){
        boolean bool = false;
        if (a * d - b * c != 0){
            bool = true;
        }
        return bool;
    }
    public double getX(){
        return (e * d - b * f) / (a * d - b * c);
    }
    public double getY(){
        return (a * f - e * c) / (a * d - b * c);
    }

    public static void main(String[] args) {
        System.out.println("请输入四个点的坐标值");
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble(), y1 = input.nextDouble();
        double x2 = input.nextDouble(), y2 = input.nextDouble();
        double x3 = input.nextDouble(), y3 = input.nextDouble();
        double x4 = input.nextDouble(), y4 = input.nextDouble();
        double a = - (y2 - y1) / (x2 - x1);
        double b = 1.0, d = 1.0;
        double c = - (y4 - y3) / (x4 -x3);
        double e = a * x1 + y1;
        double f = c * x3 + y3;
        LinearEquation le = new LinearEquation(a, b, c, d, e, f);
        boolean bool = le.isSolvable();
        if (bool){
            System.out.println("x is " + le.getX() + " and y is " + le.getY());
        } else
            System.out.println("The equation has no solution");
    }
}
