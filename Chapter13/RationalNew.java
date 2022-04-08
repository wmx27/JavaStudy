package Chapter13;

import java.math.BigInteger;

public class RationalNew {
    //重写rational类
    private BigInteger numrator;
    private BigInteger denominator;

    public int equal(BigInteger n1,BigInteger n2){
        if(n1.compareTo(n2)==0)
            return 1;
        else
            return 0;
    }
    public RationalNew(){
    }

    public RationalNew(BigInteger numerator,BigInteger denominator){
        //具体设计要存储最简
        BigInteger gcd=gcd(numerator,denominator);
        this.numrator=numerator.divide(gcd);
        this.denominator=denominator.divide(gcd);
    }
    public static BigInteger gcd(BigInteger n1,BigInteger d1){

        if(n1.compareTo(new BigInteger("0"))==-1)
            n1.multiply(new BigInteger("-1"));
        if(d1.compareTo(new BigInteger("0"))==-1)
            d1.multiply(new BigInteger("-1"));

        BigInteger gcd=new BigInteger("1");
        for(BigInteger i=new BigInteger("1");i.compareTo(n1)<=0&&i.compareTo(d1)<=0;i=i.add(new BigInteger("1")))
        {

            if((n1.remainder(i).compareTo(new BigInteger("0"))==0)&&(d1.remainder(i).compareTo(new BigInteger("0"))==0))
            {
                gcd=i;
            }
        }
        return gcd;
    }
    public BigInteger getNumbertor(){
        return this.numrator;
    }
    public BigInteger getDenominator(){
        return this.denominator;
    }
    public RationalNew add(RationalNew secondRational){
        BigInteger n1=secondRational.getDenominator().multiply(numrator).add(secondRational.getNumbertor().multiply(denominator));
        BigInteger n2=denominator.multiply(secondRational.getDenominator());
        return new RationalNew(n1,n2);
    }
    public RationalNew subtract(RationalNew secondRational){
        BigInteger n1=secondRational.getDenominator().multiply(numrator).subtract(secondRational.getNumbertor().multiply(denominator));
        BigInteger n2=denominator.multiply(secondRational.getDenominator());
        return new RationalNew(n1,n2);
    }
    public RationalNew multiply(RationalNew secondRational){
        BigInteger n1=numrator.multiply(secondRational.getNumbertor());
        BigInteger n2=denominator.multiply(secondRational.getDenominator());
        return new RationalNew(n1,n2);
    }
    public RationalNew divide(RationalNew secondRational){
        BigInteger n1=numrator.multiply(secondRational.getDenominator());
        BigInteger n2=denominator.multiply(secondRational.getNumbertor());
        return new RationalNew(n1,n2);
    }
    public String toString(){
        if(denominator.compareTo(new BigInteger("0"))==0)
            return null;
        else if(numrator.compareTo(new BigInteger("0"))==0)
            return "0";
        else
            return ""+numrator+"/"+denominator;
    }

    public static void main(String[] args) {
        RationalNew a=new RationalNew(new BigInteger("-1"),new BigInteger("2"));
        RationalNew b=new RationalNew(new BigInteger("1"),new BigInteger("2"));
        RationalNew c=a.multiply(b);
        System.out.println(c.toString());
        RationalNew d=a.add(b);
        System.out.println(d.toString());

    }
}
