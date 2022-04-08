package Chapter11;
import java.util.ArrayList;
import java.util.Scanner;
public class addDemo {
    public static void main(String[] args) {
        int num1=(int)(Math.random()*10);
        int num2=(int)(Math.random()*10);
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> answer=new ArrayList<>();
        System.out.print("What is "+num1+" + "+num2+" ? ");
        answer.add(new Integer(input.nextInt()));

        while(answer.contains(num1+num2)==false)
        {
            System.out.print("Wrong answer .Try again. ");
            System.out.print("What is "+num1+" + "+num2+" ? ");
            Integer num=new Integer(input.nextInt());
            if(answer.contains(num))
                System.out.println("You already entered "+num);
            else
                answer.add(num);
        }
        System.out.println("You got it");
    }
}
