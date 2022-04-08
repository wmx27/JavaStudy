package Chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class removeDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.print("Enter 10 Integer:");
        for(int i=0;i<10;i++)
            list.add(new Integer(input.nextInt()));
        System.out.println(list.toString());
        removeDuplicate(list);
        System.out.println(list.toString());

    }

    public static void removeDuplicate(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++)
        {
            Integer num=list.get(i);
            list.remove(i);
            if(list.contains(num)==false)
                list.add(i,num);
            else
                i--;
        }
    }
}
