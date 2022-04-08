package Chapter12;

import Chapter9.LinearEquation;

import java.io.IOException;
import java.util.Scanner;

public class QuotientWithException {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter two integer: ");
        int num1=input.nextInt();
        int num2= input.nextInt();

        try{
            int result = quotient(num1,num2);
            System.out.println("num1"+" / "+num2+" is "+result);
        }
//        catch(Exception ex){
//            父类异常捕获应该在子类异常之后 否则会报错 Exception 'java.lang.ArithmeticException' has already been caught
//        }
        catch ( ArithmeticException | NullPointerException ex){//多捕获特征
            System.out.println("Exception :an integer cannot be divided by zero");
        }
        System.out.println("Execution continues ...");
    }

    public static int quotient(int num1,int num2){
        if(num2==0)
            throw new ArithmeticException("Divisor cannoot be zero");
        return num1/num2;
    }
}
