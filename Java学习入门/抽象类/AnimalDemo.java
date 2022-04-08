package Java学习入门.抽象类;
/*
    测试类
 */

/*抽象类中不一定有抽象方法 但有抽象方法的类一定是抽象类*/
public class AnimalDemo {
    public static void main(String[] args) {
        /*
            Animal a=new Animal();  抽象类不能具体化 会报错
            a.eat();*/
        //创建抽象对象 参照多态方式 利用子类对象实例化（叫做抽象类多态）
        //（抽象类子类要求要么重写抽象类中的所有抽象方法 要么本身也是抽象类）
        Animal a=new Cat();
        a.eat();
        a.sleep();
        System.out.println("------------------");
        a.show();
    }
}
