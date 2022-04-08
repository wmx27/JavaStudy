package Chapter10;

public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isEven(int value)
    {
        return value%2==0?true:false;
    }
    public static boolean isOdd(int value)
    {
        return value%2!=0?true:false;
    }
    public static boolean isPrime(int value)
    {
        if(value<=1)return false;
        else
        {
            for(int i=2;i<=Math.sqrt((int)value);i++)
                if(value%i==0)
                    return false;
            return true;
        }
    }

    public boolean isEven(MyInteger m)
    {
        return m.value%2==0?true:false;
    }
    public boolean isOdd(MyInteger m)
    {
        return m.value%2!=0?true:false;
    }
    public boolean isPrime(MyInteger m)
    {
        if(m.value<=1)return false;
        else
        {
            for(int i=2;i<=Math.sqrt((int)m.value);i++)
                if(m.value%i==0)
                    return false;
            return true;
        }
    }

    public boolean equals(int num)
    {
        return num==this.value?true:false;
    }
    public boolean equals(MyInteger num)
    {
        return num.value==this.value?true:false;
    }
}
