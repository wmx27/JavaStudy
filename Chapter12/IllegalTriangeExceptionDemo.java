package Chapter12;

public class IllegalTriangeExceptionDemo {
    public static void main(String[] args) {
        try {
            Triangle first=new Triangle(1,2,1.5);
            System.out.println();
            Triangle a = new Triangle(1, 0.5, 0.2);
        }
        catch(IllegalTriangeException ex){
            System.out.println(ex.getMessage());

        }
    }
}
class IllegalTriangeException extends Exception{
    private String s;
    public IllegalTriangeException(String s){
        this.s=s;
    }
    @Override
    public String getMessage(){
        return s;
    }
}
class Triangle{
    private double side1;
    private double side2;
    private double side3;
    public Triangle(){

    }

    public Triangle(double side1, double side2, double side3)throws IllegalTriangeException{
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if(side1+side2<=side3||side1+side3<=side2||side2+side3<=side1)
            throw new IllegalTriangeException("创建失败(IllegalException错误)");
        else
            System.out.println("创建成功");
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
    public double getArea(){
        double p=getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3))/4;
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }
    @Override
     public String toString(){
        return "Triangle: side1 = "+side1+" side2 = "+side2+" side3 = "+side3;
    }
}