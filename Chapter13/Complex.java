package Chapter13;

public class Complex {
    private double a;
    private double b;
    public Complex(){
        a=0;
        b=0;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Complex(double a, double b){
        this.a=a;
        this.b=b;
    }
    public Complex add(Complex num){
        Complex n1=new Complex(this.a+num.getA(),this.b+num.getB());
        return n1;
    }
    public Complex subtract(Complex num){
        Complex n1=new Complex(this.a-num.getA(),this.b-num.getB());
        return n1;
    }
    public Complex multiply(Complex num){
        Complex n1=new Complex(this.a*num.getA()-this.b*num.getB(),this.b*num.getA()+this.a*num.getB());
        return n1;

    }
    public Complex divide(Complex num){
        Complex n1=new Complex(this.a*num.getA()+this.b*num.getB()/(Math.pow(num.getA(),2)+Math.pow(num.getB(),2)),
                (this.b*num.getA()-this.a*num.getB())/(Math.pow(num.getA(),2)+Math.pow(num.getB(),2)));
        return n1;
    }
    public double abs(){
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
}
