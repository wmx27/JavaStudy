package Chapter8;
import java.util.Scanner;
public class MaxBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix:");
        int number = input.nextInt();
        int[][] arr = new int[number][number];
        for (int i = 0; i < number; i++)
            for (int j = 0; j < number; j++)
                arr[i][j] = input.nextInt();
        for (int substring_length = number; substring_length > 0; substring_length--)
        {
            for (int i = 0; i <= number - substring_length; i++)
            {
                for (int j = 0; j <= number - substring_length; j++)
                {
                    if (is_substring(arr, i, j, substring_length))
                    {
                        System.out.println("The maximum square submatrix is at (" + i + ", " + j + ") with size " + substring_length);
                        return;
                    }
                }
            }
        }
    }
    public static boolean is_substring(int[][] arr, int i, int j, int length)
    {
        for (int x = i ; x < i + length ; x++)
        {
            for (int y = j ; y < j + length ; y++)
            {
                if (arr[x][y] != 1)
                {
                    return false;
                }
            }
        }
        return true;
    }

}
