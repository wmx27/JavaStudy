package Chapter12;

public class NumberFormatExceptionDemo extends Exception{

    public static void main(String[] args) {
            try {
                System.out.println(bin2Dec("01102"));
            }
            catch(NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
        }
    public static int bin2Dec(String binaryString){
    int sum=0;
    for(int i=0;i<binaryString.length();i++)
    {
        if(binaryString.charAt(i)>='2'||binaryString.charAt(i)<'0')
            throw new NumberFormatException("不是二进制");
        else
            sum=(binaryString.charAt(i)-'0')+sum*2;
    }
    return sum;
    }
}
