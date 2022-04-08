package Chapter7;

public class MergeList {
    public static void main(String[] args) {
        int[] arr1= {1,3,5,7,8,9,15,45,65,87};
        int[] arr2= {1,2,3,8,16,22,33,66,89,99};
        int[] arr=merge(arr1,arr2);
        for(int i=0;i<arr1.length+ arr2.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static int[] merge(int[ ] list1,int[] list2)
    {
        int len=list1.length+list2.length;
        int[] arr=new int[len];
        int j=0,k=0;
        for(int i=0;i<len;i++)
        {
            if(k!= list2.length&&j!=list1.length&&list1[j]>list2[k])
                arr[i]=list2[k++];
            else if(k!= list2.length&&j!=list1.length&&list1[j]<=list2[k])
                arr[i]=list1[j++];
            else if(k== list2.length&&j!=list1.length)
                arr[i]=list1[j++];
            else if(k!= list2.length&&j==list1.length)
                arr[i]=list2[k++];
        }
        return arr;
    }
}
