package Chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstuserPack {
    public static void main(String[] args) {
        ArrayList<Integer>list =new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number of the objects ");
        int num= input.nextInt();
        System.out.print("Enter the weight of the objects:");
        for(int i=0;i<num;i++)
        {
            int weight=input.nextInt();
            if(list.size()==0)
                list.add(new Integer(weight));
            else if(list.get(list.size()-1)+weight<=10)
                list.set(list.size()-1,list.get(list.size()-1)+weight);
            else
                list.add(new Integer(weight));
        }
            System.out.println(list.toString());


    }
}
