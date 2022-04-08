package Chapter9;
import javafx.geometry.Point2D;

import java.util.*;
public class Study {
    public static void main(String[] args) {
        //使用Java库中的类
        //***Date类***
        long a=100000000;
        Date date1=new Date();
        Date date2=new Date(a);//创建一个距Unix时间戳为a毫秒的时间
        //getTime()返回的是当前时间到Unix时间戳的毫秒数long类型
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        //toString()返回的是时间 代表日期和时间的字符串 如果是具体毫秒数创建的时间 则返回距离毫秒数是为设定的时间
        System.out.println(date1.toString());
        System.out.println(date2.toString());

        System.out.println("--------------------------------------");
        //***Random***
        //无参构造方法是以当前时间为种子创建的一个Random对象
        Random r1=new Random();
        //有参构造方法是以long类型的数作为种子创建的一个Random对象
        Random r2=new Random(a);
        //nextInt()方法是为了随机产生一个Int类型的数然后返回
        System.out.println(r1.nextInt());
        //nextInt(int x)方法是为了随机产生一个Int类型(0到x但不包括x)的数然后返回
        System.out.println(r1.nextInt(15));
        //nextLong()是随机产生一个Long类型的随机数返回
        System.out.println(r2.nextLong());
        //nextDouble()方法产生一个0.0到1.0不包含1.0的随机double类型数
        System.out.println(r2.nextDouble());
        //nextFloat()随机产生一个0.0F到1.0F不包含1.0F的随机float类型数
        System.out.println(r2.nextFloat());
        //nextBoolean()随机产生一个boolean类型的随机数
        System.out.println(r2.nextBoolean());


        System.out.println("--------------------------------------");
        //***Point2D***
        //Point2D(double x,double y)有参构造方法
        Point2D p1=new Point2D(1.0,2.0);
        Point2D p2=new Point2D(3.0,2.0);
        System.out.println(p1);
        System.out.println(p2);
        //distance(double x,double y)返回该点到（x，y）之间的double类型的距离
        System.out.println(p1.distance(1.0,3.0));
        //distance(Point2D p)返回该点到给定点的double类型的距离
        System.out.println(p1.distance(p2));
        //getX()返回x坐标double类型
        System.out.println(p1.getX());
        //getY()返回y坐标double类型
        System.out.println(p1.getY());
        //midpont(Point2D p)返回p点和该点的中点坐标 类型为Point2D
        System.out.println(p1.midpoint(p2));
        //toString()返回该点的字符串表示 直接输出该点也是输出的字符串
        System.out.println(p1.toString());

    }
    private class p{
        //允许private修饰内部类 但是不允许private修饰外部类
    }
    public class s{
        //内部可以有多个public内部类
    }
}
/*public class ss{
// 外部类只有一个是public 否则会报错
}*/