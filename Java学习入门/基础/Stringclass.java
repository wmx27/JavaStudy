package Java学习入门.基础;

public class Stringclass {
    public static void main(String[] args) {
        //构造方法得到对象
        char[]  chs={'a','b','c'};
        String s1=new String(chs);
        String s2=new String(chs);

        //直接赋值的方式得到对象
        String s3="abc";
        String s4="abc";

        System.out.println(s1 == s2);//s1和s2是不同对象
        System.out.println(s1 == s3);//s1和s3是不同对象
        System.out.println(s3 == s4);//s3和s4指向的是相同的字符串
        System.out.println(s1.equals(s2));//直接比较内容
        System.out.println("-------------");

    }
}
