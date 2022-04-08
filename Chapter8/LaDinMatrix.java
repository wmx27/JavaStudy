package Chapter8;
import java.util.Arrays;
import java.util.Scanner;
public class LaDinMatrix {
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        System.out.print("Enter the n:");
        int number= input.nextInt();
        int flag=1;
        System.out.println("Enter "+number+" rows of letters separated by spaces:");
        char[][] arr=new char[number][number];
        for(int i=0;i<number;i++)
            for(int j=0;j<number;j++)
            {
                arr[i][j]=input.next().charAt(0);
                if(arr[i][j] < 'A'||arr[i][j]>='A'+number)
                    flag=0;
            }
        if(flag==0)
        {
            char c=(char)('A'+number-1);
            System.out.println("Wrong input: the letters must be from " + 'A' + " to " +c);
            return;
        }
        int[] record = new int[number];

        for(int i=0;i<number;i++)
        {
            Arrays.fill(record, 0);
            for(int j=0;j<number;j++)
                record[(int)(arr[i][j]-'A')]++;
            for(int K=0;K<number;K++)
            {
                if(record[K]!=1)
                {
                    char c=(char)('A'+number-1);
                    System.out.println("Wrong input: the letters must be from " + 'A' + " to " +c);
                    return;
                }
            }
        }

        for(int i=0;i<number;i++)
        {
            Arrays.fill(record, 0);
            for(int j=0;j<number;j++)
                record[(int)(arr[i][j]-'A')]++;
            for(int k=0;k<number;k++)
            {
                if(record[k]!=1)
                {
                    char c=(char)('A'+number-1);
                    System.out.println("Wrong input: the letters must be from " + 'A' + " to " +c);
                    return;
                }
            }
        }

        System.out.println("The input array is a Latin square");
    }
}
