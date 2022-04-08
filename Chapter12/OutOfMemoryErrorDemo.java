package Chapter12;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorDemo {

    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<String>();
            while (true) list.add(new String("Consume more memory!"));
        }
        catch(OutOfMemoryError ex){
            System.out.println("出现了OutOfMemoryError");
        }
    }
}
