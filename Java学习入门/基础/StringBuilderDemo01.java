package Java学习入门.基础;

public class StringBuilderDemo01 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        System.out.println("sb:"+sb);
        System.out.println("sb.length()"+sb.length());
        System.out.println("sb:"+sb.append("abs"));
        System.out.println("sb.length()"+sb.length());
        System.out.println("sb:"+sb.reverse());//reverse()翻转字符串

        //格式化编程
        sb.append("hello").append(" the").append(" world");
        System.out.println("sb:"+sb);

        //需求 将int数组数据按照一定格式转换为字符串返回
        int[] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(arrayToString(arr));
    }

    public static String arrayToString(int[] arr)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("[");

        for(int i=0;i<arr.length;i++)
        {
            if(i==arr.length-1)
                sb.append(arr[i]);
            else
                sb.append(arr[i]).append(",");
        }
        sb.append("]");
        String s= sb.toString();
        return s;
    }
}
