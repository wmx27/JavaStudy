package Chapter7;
import java.util.Scanner;
public class PrintDifferentNumber {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int temp,flag=1,k=0;
        int[] arr=new int[10];
        System.out.print("Enter 10 numbers:");
        for(int i=0;i<10;i++)
        {
            flag=1;
            temp= input.nextInt();
            for(int j=0;j<i;j++)
                if(temp==arr[j])
                {flag=-1;break;}
            if(flag==1)
                arr[k++]=temp;
        }
        System.out.println("The number of different numbers is "+k);
        for(int i=0;i<k;i++)
            System.out.print(arr[i]+" ");

    }
}
