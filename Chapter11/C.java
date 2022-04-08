package Chapter11;
import java.lang.Object;
class A{
    public A(){
        System.out.println("A被调用");
    }
}

class B extends A{
    public B(){
        System.out.println("B被调用");
    }
}
public class C {
    public static void main(String[] args) {
        B b = new B();
        int s=4;
        C c= new C();
        Object object = new Object();
        System.out.println(c);
        System.out.println(object);
        System.out.println(object.toString());

        //尝试将实例new int[50] new Integer[50] new String[50] new object[50] 赋值给Object[]类型的变量
        //Object[] arr=new int[50];//Incompatible types. Found: 'int[]', required: 'java.lang.Object[]'
        Object[] arr=new Integer[50];
        Object[] arr1=new String[50];
        Object[] arr2=new Object[50];

        Object o=new A();
        //A a=o;//发现会产生错误 问题在于编译器看到的是o是一个Object类型的 不能清楚的看到这个实际类型
        //我们可以这样
        A a=(A)o;//称之为向上转换 但是是有风险的所以在转换之前 我们用instanceof关键字来判断这个实际类型可以符合
        System.out.println(o instanceof A);//true
        System.out.println(o instanceof Object);//true
        System.out.println(o instanceof B);//false




    }
}
