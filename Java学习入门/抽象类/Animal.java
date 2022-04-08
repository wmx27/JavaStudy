package Java学习入门.抽象类;
/*
    Java学习入门.抽象类
*/
public abstract class Animal{
    //抽象类的成员特点
    private int age= 20;
    private final String city ="北京";
    int num;

    public void show()
    {
        age=40;
        System.out.println(age);
        //city="上海"; 报错 因为成员变量为常量
        System.out.println(city);
    }

    //成功 抽象类是不能直接实例化   但是可以有构造方法用于子类访问父类的初始化
    public Animal()
    {}

    //抽象方法
    public abstract void eat();

    //抽象类中包含成员方法 可以抽象 也可以不抽象
    public void sleep()
    {
        System.out.println("睡觉");
    }
    public static void sss(){

    }

}
