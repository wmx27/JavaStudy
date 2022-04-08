package Chapter11;

public class CastingDemo {
    public static void main(String[] args) {
        Object object1=new Circle(1);
        Object object2=new Rectangle(1,1);

        displayObject(object1);
        displayObject(object2);

        Object object=new Object();
        System.out.println(object instanceof Circle);
        //Circle circle=(Circle)object; 报错 过不了

        //类似与toString（）在Object类中还定义了equals（）方法：public boolean equals(Object o)
        //这个方法来测试两个对象是否相等 即引用值是否相等
        Object object3=new Object();

        System.out.println("\n"+object.equals(object1));
        System.out.println(object.equals(object));



    }
    public static void displayObject(Object object){
        if(object instanceof Circle)
        {
            System.out.println("The circle area is "+((Circle)object).getArea());
            System.out.println("The circle diameter is "+((Circle)object).getDiamter());
        }
        else if(object instanceof Rectangle)
        {
            System.out.println("The rectangle area is "+((Rectangle)object).getArea());
        }
    }
}
