package Chapter7;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={10,9,8,7,6,5,4,3,2,1};
        int number=10;
        for(int i=0;i<number;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        for(int i=0;i<number-1;i++)
            for(int j=i+1;j<number;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        for(int i=0;i<number;i++)
            System.out.print(arr[i]+" ");
    }
}
