package Chapter13;

import java.math.BigInteger;
import java.util.Scanner;

public class work13point21 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a,b,c:");
        String[] arr=new String[3];
        for(int i=0;i<3;i++)
            arr[i]=input.next();
        BigInteger a=new BigInteger(arr[0]);
        BigInteger b=new BigInteger(arr[1]);
        BigInteger c=new BigInteger(arr[2]);
        Rational h=new Rational(b.multiply(new BigInteger("-1")),a.multiply(new BigInteger("2")));
        Rational k=new Rational(a.multiply(c).multiply(new BigInteger("4")).subtract(b.multiply(b)),a.multiply(new BigInteger("4")));

        System.out.println(h.toString());
        System.out.println(k.toString());
    }
}
