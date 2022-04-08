package Chapter7;

public class GameLockerProblem {
    public static void main(String[] args) {
        int[] L=new int[101];
        for(int i=1;i<=100;i++)
            L[i]=0;
        for(int i=1;i<=100;i++)
            for(int j=1;j<=100;j+=i)
                if(L[j]==0)
                    L[j]=1;
                else
                    L[j]=0;
        for(int i=1;i<=100;i++)
            if(L[i]==1)
            System.out.print(i+" ");
    }

}
