package Chapter10;

public class TaxDemo {
        public static void main(String[] args) {
                int[][] bracket={
                        {27050,65550,136750,297350},
                        {45200,109250,166500,297350},
                        {22600,54625,83250,148675},
                        {36250,93650,151650,297350}
                };
                double[] rates={0.15,0.275,0.305,0.355,0.391};
                for(int i=2001;i<=2009;i++)
                {
                        System.out.println(i+"年");
                        for(int j=0;j<4;j++)
                        {
                                System.out.println("the filingStatus is "+j);
                                for(int k=50000;k<60000;k+=1000)
                                {
                                        Tax t= new Tax(j,bracket,rates,k);
                                        System.out.println("收入："+k+" 税："+(int)t.getTax());
                                }
                        }
                }
        }

}
class Tax{


        private int filingStatus;
        public final  int SINGLE_FILER = 0;
        public final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
        public final int MARRIED_SEPARATELY = 2;
        public final int HEAD_OF_HOUSEHOLD = 3;
        private int[][] bracket;
        private double[] rates;
        private double taxableIncome;

        public Tax() {
        }

        public Tax(int filingStatus, int[][] bracket, double[] rates, double taxableIncome) {
                this.filingStatus = filingStatus;
                this.bracket = bracket;
                this.rates = rates;
                this.taxableIncome = taxableIncome;
        }

        public void setFilingStatus(int filingStatus) {
                this.filingStatus = filingStatus;
        }

        public void setBracket(int[][] bracket) {
                this.bracket = bracket;
        }

        public void setRates(double[] rates) {
                this.rates = rates;
        }

        public void setTaxableIncome(double taxableIncome) {
                this.taxableIncome = taxableIncome;
        }

        public int getFilingStatus() {
                return filingStatus;
        }

        public int[][] getBracket() {
                return bracket;
        }

        public double[] getRates() {
                return rates;
        }

        public double getTaxableIncome() {
                return taxableIncome;
        }

        public double getTax()
        {
                int num=0;//选择其处于哪个收入阶段
                for(int i=0;i<4;i++)
                {
                        if(this.taxableIncome<=this.bracket[this.filingStatus][i]) {
                                num = i;
                                break;
                        }
                        else if(this.taxableIncome>this.bracket[this.filingStatus][3])
                        {
                                num=4;
                                break;
                        }
                }
                double tax=this.taxableIncome*this.rates[num];
                return tax;
        }
}
