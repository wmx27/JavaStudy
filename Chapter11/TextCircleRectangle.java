package Chapter11;
import java.util.ArrayList;
import java.util.Arrays;

public class TextCircleRectangle {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("A circle "+circle.toString());
        System.out.println("The color is "+circle.getColor());
        System.out.println("The radius is "+circle.getRadius());
        System.out.println("The area is "+circle.getArea());
        System.out.println("The diameter is "+circle.getDiamter());

        Rectangle rectangle = new Rectangle(2,4);
        System.out.println("\nA rectangle "+rectangle.toString());
        System.out.println("The area is "+rectangle.getArea());
        System.out.println("The perimter is "+rectangle.getPerimeter());

        Integer[] array={3,5,69,78,45};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list.toString());
        System.out.println(java.util.Collections.max(Arrays.asList(array)));
    }
}
