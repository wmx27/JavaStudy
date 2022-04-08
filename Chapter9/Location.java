package Chapter9;
import java.util.Scanner;
public class Location {
    public static int row = 0, column = 0;
    public static double maxValue = 0.0;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array:");
        int rows = input.nextInt(), cols = input.nextInt();
        double[][] arr = new double[rows][cols];
        System.out.println("Enter the array:");
        for (int a = 0 ; a < rows ; a++)
        {
            for (int b = 0 ; b < cols ; b++)
            {
                arr[a][b] = input.nextDouble();
            }
        }
        Location l = new Location();
        l = locateLargest(arr);
        System.out.println("The location of the largest elements is " + Location.maxValue +
                " at (" + Location.row + ", " + Location.column + ")");


    }
    public static Location locateLargest(double[][] a)
    {
        Location l = new Location();
        for (int m = 0 ; m < a.length ; m++)
        {
            for (int n = 0 ; n < a[0].length ; n++)
            {
                if (Location.maxValue < a[m][n])
                {
                    Location.maxValue = a[m][n];
                    Location.row = m;
                    Location.column = n;
                }
            }
        }
        return l;
    }
}
