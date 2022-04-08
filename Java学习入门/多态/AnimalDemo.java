package Java学习入门.多态;
/*
   测试类
 */
/*
    Java学习入门.多态：
        同一个对象 在不同时刻表现出来的不同形态

        举例：
             cat = new 猫();
             animal =new 猫();
             这里猫体现出了不同的形态 这就是多态

         多态的前提和实现
             有继承/实现关系
             有方法重写
             有父类引用指向子类对象
*/
public class AnimalDemo {
    public static void main(String[] args) {
        //有父类引用指向子类对象
        Animal a=new Cat();

        System.out.println(a.age);//输出40 输出父类的
//        System.out.println(a.weight); 会报错 因为编译时会看左边 认为是Animal

        a.eat();//输出 猫吃鱼 编译看左边 但是运行看子类
//        a.playGame(); 发现也会报错 编译的时候只看左边的父类
        //原因 因为成员方法有重写 但是成员变量没有
        System.out.println("-----------------------------------");
        //创建动物操作类的对象 调用方法
        AnimalOperator ao = new AnimalOperator();
        Cat c= new Cat();
        ao.useAnimal(c);//输出  猫吃鱼

        Dog d= new Dog();
        ao.useAnimal(d);

        Pig p=new Pig();
        ao.useAnimal(p);
        //好处 提高了程序的扩展性：定义方法是 使用父类型作为参数 在将来使用的时候 使用具体子类型参与操作
        //弊端 不能使用子类的特有功能
        System.out.println("-----------------------------------");

        /*多态中的转型   向上装型 向下转型*/
        //向上转型
        Animal a2=new Cat();
        a.eat();
        //a.playGame(); 会报错

        /* 创建Cat类的对象
        Cat c2 =new Cat();
        c.eat();
        c.playGame();
        */

        //向下转型
        Cat c3=(Cat)a2;
        c.eat();
        c.playGame();

    }
}
