package Chapter10;

public class MyString2Demo {
    public static void main(String[] args) {
        MyString2 m=new MyString2();
        System.out.println(m.length());
        System.out.println(m);
    }
}

class MyString2{
    private char[] chars;
    private int length;
    public MyString2() {

    }

    public MyString2(char[] chars) {
        this.chars = chars;
        this.length=chars.length;
    }

    public int length() {
        return this.length;
    }

    public char charAt(int index) {
        return this.chars[index];
    }

    public MyString2 substring(int begin,int end) {
        char[] s=new char[end-begin+1];
        int j=0;
        for(int i=begin;i<=end;i++)
        {
            s[j++]=this.chars[i];
        }
        this.chars=s;
        this.length=s.length;
        return this;
    }

    public MyString2 tolowerCase()
    {
        for(int i=0;i<this.length;i++)
        {
            if(this.chars[i]>='A'&&this.chars[i]<='Z')
                this.chars[i]=(char)(this.chars[i]-'A'+'a');
        }
        return this;
    }
    public boolean equals(MyString2 s)
    {
        if(this.length!=s.length)
            return false;
        else
        {
            for(int i=0;i<this.length;i++)
                if(this.chars[i]!=s.chars[i])
                    return false;
            return true;
        }
    }

    public static MyString2 valueOf(int i)
    {
        char[] s=new char[8];int k=0;
        while(i!=0)
        {

            s[k++]=(char)('0'+(i%10));
            i/=10;
        }
        char[] b=new char[k];
        for(int j=0;i<k;j++)
            b[j]=s[k-j-1];

        MyString2 s1=new MyString2(b);
        return s1;
    }
}