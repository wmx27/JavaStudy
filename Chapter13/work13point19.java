package Chapter13;

import java.util.Scanner;
import java.math.BigInteger;
public class work13point19{
    public static void main(String[] args) {
        //提示用户输入一个十进制数 然后转化为分数的形式
        Scanner input=new Scanner(System.in);
        //输入部分
        System.out.print("Enter a decimal number: ");
        String str = input.next();
        boolean bl = true;
        if (str.charAt(0) == '-')
            bl = false;
        String[] s = new String[2];
        //将整数部分和小数部分进行分开
        s = str.split("\\.");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int length = s[1].length();
        //将分子和分母按照小数的位数化为整数 然后处理这个分数
        int numerator1 = (int) (a * Math.pow(10, length) + b);
        int denominator1 = (int) Math.pow(10, length);
        //然后处这两个的最大公约数
        int greatestCommonDivisor = maxCommonDivisor(numerator1, denominator1);
        int numrator2 = numerator1 / greatestCommonDivisor;
        int denominator2 = denominator1 / greatestCommonDivisor;
        Rational r1 = new Rational(new BigInteger(numrator2 + ""), new BigInteger(denominator2 + ""));

        if (bl)
            System.out.println("The fraction number is " + r1);
        else
            System.out.println("The fraction number is -" + r1);
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;

    }


    }



class Rational extends Number implements Comparable< Rational > {
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");

    public Rational() {
        this(new BigInteger("0"), new BigInteger("1"));
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        if (denominator.compareTo(new BigInteger("0")) > 0) {
            this.numerator = numerator.divide(gcd);
        } else
            this.numerator = numerator.multiply(new BigInteger("-1")).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = new BigInteger("1");
        BigInteger n3 = new BigInteger("1");
        for (int i = 1; i <= n1.intValue() && i <= n2.intValue(); i++) {
            if ((n1.remainder(n3).equals(new BigInteger("0"))) && (n2.remainder(n3).equals(new BigInteger("0")))) {
                gcd = n3;
            }
            n3 = n3.add(new BigInteger("1"));
        }

        return gcd;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(new BigInteger("1")) || numerator.equals(new BigInteger("0"))) {
            return numerator.toString();
        } else
            return numerator.toString() + "/" + denominator.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this.subtract((Rational) other).getNumerator().equals(new BigInteger("0"))) {
            return true;
        } else
            return false;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator.divide(denominator).doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(new BigInteger("0")) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(new BigInteger("0")) < 0)
            return -1;
        else
            return 0;
    }

}