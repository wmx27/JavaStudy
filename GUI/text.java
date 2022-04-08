package GUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import java.io.File;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class text extends Application{
    ArrayList<Account> accounts=new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        accounts.add(new Account());

        Label label=new Label("请输入账户：");
        TextField textField=new TextField();
        Button button=new Button("确认");

        HBox hBox=new HBox();
        hBox.getChildren().add(label);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(button);

        Pane pane=new Pane();
        pane.getChildren().add(hBox);

        Scene scene=new Scene(pane,500,250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("银行自助机");
        primaryStage.show();

        button.setOnAction(event -> {
            String s=textField.getText();
            int id=returnId(Integer.parseInt(s));

            Stage stage=new Stage();
            Button button1=new Button("存款");
            Button button2=new Button("取款");

            HBox hBox1=new HBox();
            hBox1.getChildren().add(button1);
            hBox1.getChildren().add(button2);

            Pane pane1=new Pane();
            pane1.getChildren().add(hBox1);

            Scene scene1=new Scene(pane1,500,250);

            stage.setScene(scene1);
            stage.setTitle("选项");
            stage.show();

            button1.setOnAction(event1 -> {
                Stage stage1=new Stage();
                Label label1=new Label("请输入金额：");
                TextField textField1=new TextField();
                Button button3=new Button("确认");

                HBox hBox2=new HBox();
                hBox2.getChildren().add(label1);
                hBox2.getChildren().add(textField1);
                hBox2.getChildren().add(button3);

                Pane pane2=new Pane();
                pane2.getChildren().add(hBox2);

                Scene scene2=new Scene(pane2,500,250);

                stage1.setScene(scene2);
                stage1.setTitle("存款");
                stage1.show();

                button3.setOnAction(event2 -> {
                    String s1=textField1.getText();
                    int money=Integer.getInteger(s1);
                    //.get(id).deposit(money);
                });
            });


            button2.setOnAction(event1 -> {
                Stage stage1=new Stage();
                Label label1=new Label("请输入金额：");
                Button button3=new Button("确认");
                TextField textField1=new TextField();

                HBox hBox2=new HBox();
                hBox2.getChildren().add(label1);
                hBox2.getChildren().add(textField1);
                hBox2.getChildren().add(button3);

                Pane pane2=new Pane();
                pane2.getChildren().add(hBox2);

                Scene scene2=new Scene(pane2,500,250);

                stage1.setScene(scene2);
                stage1.setTitle("取款");
                stage1.show();

                button3.setOnAction(event2 -> {
                    String s1=textField1.getText();
                    int money=Integer.getInteger(s1);
                    //accounts.get(id).withdraw(money);
                });
            });

        });
    }

    public int returnId(int id){

        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}

class Transaction{
    private java.util.Date date;
    private char type;
    private double amount;
    private double balance;
    private String decription=new String();

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

    public void setDecription(String decription) {
        this.decription = decription;
    }

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

    public String getDecription() {
        return decription;
    }

    public Transaction(char type, double amount, double balance, String decription) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.decription = decription;
        date=new Date();
    }
}

class Account{
    private String name;
    private int id=0;
    private double balance=0;
    private ArrayList<Transaction> transactions=new ArrayList<>();
    private double annualInterestRate=0;
    private java.util.Date dateCreated;
    Scanner input=new Scanner(System.in);

    public void setName(String name) {
        this.name = name;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double annualInterestRate(){
        return annualInterestRate;
    }

    public Account(){
        dateCreated=new Date();
    }
    public Account(int id,double balance){
        this.id=id;
        this.balance=balance;
        dateCreated=new Date();
    }

    public Account(double annualInterestRate,double balance,int id,String name){
        this.annualInterestRate=annualInterestRate;
        this.balance=balance;
        this.id=id;
        this.name=name;
        dateCreated=new Date();
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

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/1200;
    }

    public double getMonthlyInterest(){
        return balance*annualInterestRate/1200;
    }

    public void withdraw(double amount){
        balance-=amount;
        transactions.add(new Transaction('W',amount,balance,"a"));
    }

    public void deposit(double amount){
        balance+=amount;
        transactions.add(new Transaction('D',amount,balance,"a"));
    }
}

