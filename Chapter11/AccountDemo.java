package Chapter11;

import java.util.ArrayList;
import java.util.Date;

public class AccountDemo {
    public static void main(String[] args) {
        Account a=new Account("wmx",12,1000);
        System.out.println("账户:"+a.getName()+" Id:"+a.getId()+" blance:"+a.getBalance());
        a.withDraw(100.0);
        System.out.println("提出100元后：");
        System.out.println("账户:"+a.getName()+" Id:"+a.getId()+" blance:"+a.getBalance());

    }
}

class Account{
    private String name;
    private int id;
    private double balance;
    private double annualInterestRate;
    private ArrayList<Transactions> Transactions=new ArrayList<>();

    public Account(){
    }
    public Account(String name,int id,double balance){
        this.balance=balance;
        this.name=name;
        this.id=id;
        this.annualInterestRate=0;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public ArrayList<Transactions> getTransactions() {
        return Transactions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setTransactions(ArrayList<Chapter11.Transactions> transactions) {
        Transactions = transactions;
    }

    public void withDraw(double amount){
        this.balance-=amount;
        this.Transactions.add(new Transactions('W',amount,this.balance,""));
    }
    public void deposit(double amount){
        this.balance+=amount;

        this.Transactions.add(new Transactions('D',amount,this.balance,""));
    }

}

class Transactions{
    private java.util.Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Date getDate() {
        return date;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transactions(char type, double amount, double balance, String description) {
        this.date=new java.util.Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
}