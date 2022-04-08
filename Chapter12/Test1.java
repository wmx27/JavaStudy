package Chapter12;

public class Test1 {
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            System.out.print(i+" ");
            try{
                p1();
                //System.out.println(1/0);
            }
            catch(Exception ex){

            }

        }
    }
    static void p1() throws Exception{
        p2();
    }
    static void p2(){
        System.out.println(1/0);
    }
}
