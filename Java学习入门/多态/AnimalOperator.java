package Java学习入门.多态;

public class AnimalOperator {
    /*
    public void useAnimal(Cat c)
    {
        c.eat();
    }
    public void useAnimal(Dog d)
    {
        d.eat();
    }*/
    public void useAnimal(Animal a)
    {
        a.eat();
//        a.lookDoor();  会报错 不能访问具体子类所特有的功能
    }


}
