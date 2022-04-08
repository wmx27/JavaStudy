package Chapter8;
import java.text.DecimalFormat;
import java.util.Scanner;
public class CenterCity
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("#0.00");
        System.out.print("Enter the number of cities:");
        int number= input.nextInt();
        double[][] arr=new double[number][2];
        double[] sum=new double[number];//创建一个存放距离和的数组
        System.out.println("Enter the coordinates of the cities:");
        for(int i=0;i<number;i++)
            for(int j=0;j<2;j++)
                arr[i][j] = input.nextDouble();
        for(int i=0;i<number;i++)
        {
            sum[i]=0;
            for(int j=0;j<number;j++)
            {
                sum[i]+=distance(arr,i,j);
            }
        }
        double min=sum[0];int minnumber=0;
        for(int i=0;i<number;i++)
            if(sum[i]<min)
            {
                min=sum[i];
                minnumber=i;
            }
        System.out.println("The central city is at "+arr[minnumber][0]+" "+arr[minnumber][1]);
        System.out.println("the distance to all cities is "+df.format(min));
    }
    public static double distance(double arr[][],int i,int j)
    {
        double dis=Math.sqrt(Math.pow(Math.abs(arr[i][0]-arr[j][0]),2)+Math.pow(Math.abs(arr[i][1]-arr[j][1]),2));
        return dis;
    }
}
