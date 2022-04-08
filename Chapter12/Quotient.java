package Chapter12;
import java.util.Scanner;
public class Quotient {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.print("Enter two integer: ");
        int num1= input.nextInt();
        int num2= input.nextInt();
        System.out.println(num1+" / "+num2+" is "+(num1/num2));
//        Object o=new Object();
//        String s=(String)o;  ClassCastException
        //注意在输入第二个数字为0的时候回产生运行时错误（浮点数除0不会产生异常）
        //常见异常可以分为三个主要类型 系统错误 异常 运行时异常  IllegalArgumentException 当传递的参数非法或者不合适时
        //属于运行时异常


        //java常见的三种操作 声明一个异常 抛出一个异常 捕获一个异常
    }

    /*
    method1（）{//异常处理
        try{
        invoke method2;
        }
        catch(Exception ex){
            Process Exception;
        }
    }

    method2() throws Exception{//声明异常 因为所有程序都可能抛出系统错误 和 运行时错误 所以不要求显式声明Error 和
    runtimeException  然而其他异常必须显式声明

    IllegalArgumentException是一个异常类 通常java中的异常类至少有两个构造方法 一个无参 一个带有可以描述这个异常的String参数的构造方法
    可以通过getMessage（）获取

    注意声明是throws 抛出是throw
    如果一个异常可以捕获父类的异常 那他就可捕获这个父类所有子类的异常
    在catch块中异常被指定的顺序十分重要 如果父类异常捕获出现在子类之前 那么就会导致编译错误
    java强制程序员处理必检异常 如果不是runtimeExceptin和Error 那么这个异常必须要try catch来调用它 或者在方法中声明会抛出的异常
    catch（Exception1 |exception2 |exception 3）{}  多捕获特征简化异常的代码编写

        if(an error occurs){
        throw new Exception;//抛出异常
        }
    }
     */
}
