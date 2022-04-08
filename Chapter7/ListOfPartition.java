package Chapter7;
import java.util.Scanner;
public class ListOfPartition {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int num,i;
        System.out.print("Enter list size:");
        num=input.nextInt();
        int[] arr=new int[num];
        System.out.print("Enter list content：");
        for(i=0;i<num;i++)
            arr[i]= input.nextInt();
        partition(arr);
        System.out.print("After the partition:");
        for(i=0;i<num;i++)
            System.out.print(arr[i]+" ");

    }
    public static int partition(int[] list)
    {

        int i=1,j=list.length-1,center= 0,temp;
        while(i<=j)
        {
            while(list[i]<list[center])
                i++;
            while(list[j]>list[center])
                j--;
            if(i<=j)
            {
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;j--;
            }
        }
        temp=list[i-1];
        list[i-1]=list[0];
        list[0]=temp;

        return i-1;
    }
}
