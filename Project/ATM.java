package Project;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;


public class ATM extends Application {
    ArrayList<Account> list=new ArrayList<>();


    //ATM设计
    @Override
    public void start(Stage primaryStage){
        BorderPane pane=new BorderPane();
        GridPane login=new GridPane();
        login.setPadding(new Insets(10,10,10,10));
        Label atm=new Label("ATM自动存取一体机");
        atm.setFont(Font.font(30));
        Label user=new Label("PIN ：");
        Label pass=new Label("密码 ：");
        TextField name=new TextField();
        PasswordField password=new PasswordField();
        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.length()>6)//限制为6位
                    password.textProperty().setValue(oldValue);
            }
        });
        Button loginButton=new Button("登录");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //判断登录是否成功
                int i,flag=0;
                String PIN= name.getText();
                String passwd=password.getText();
                for(i=0;i<list.size();i++)
                {
                    if(sameStr(list.get(i).passward,passwd)&&sameStr(list.get(i).PIN,PIN))
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                {
                    //如果登录成功 判断是不是储蓄用户 如果是储蓄用户 给账户内添加利息
                    if(list.get(i) instanceof SavingAccount)
                    ((SavingAccount)list.get(i)).rate();
                    //下面的是界面
                    int num=i;
                    Stage userStage=new Stage();
                    GridPane userPane=new GridPane();
                    Label tip3=new Label(list.get(i).PIN+"的账户");
                    Label blance=new Label("余额");
                    Label account=new Label("交易量");
                    Label waytip=new Label("方式");
                    Label blanceText=new Label(""+list.get(i).balance);
                    TextField accountText=new TextField();
                    ToggleGroup way=new ToggleGroup();
                    RadioButton deposit=new RadioButton("存款");
                    RadioButton withdraw=new RadioButton("取款");
                    deposit.setToggleGroup(way);
                    withdraw.setToggleGroup(way);
                    userPane.addRow(0,tip3);
                    userPane.addRow(1,blance,blanceText);
                    userPane.addRow(2,account,accountText);
                    HBox hBox3=new HBox();
                    hBox3.setSpacing(20);
                    hBox3.getChildren().addAll(deposit,withdraw);
                    userPane.addRow(3,waytip,hBox3);
                    userPane.setAlignment(Pos.CENTER);
                    Button OK=new Button("确认");
                    OK.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            if(deposit.isSelected())
                            {
                                String acc=accountText.getText();
                                double accNumber=Double.parseDouble(acc);
                                if(accNumber!=0) {
                                    if(accNumber>=10000)
                                    {
                                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                                        alert.setHeaderText("请联系银行工作人员");
                                        alert.showAndWait();
                                    }
                                    else if(accNumber<=10000&&list.get(num).deposit(accNumber))
                                    {
                                        blanceText.setText(""+list.get(num).balance);
                                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                                        alert.setHeaderText("存款成功");
                                        alert.showAndWait();
                                    }
                                }

                            }
                            else if(withdraw.isSelected())
                            {
                                String acc=accountText.getText();
                                double accNumber=Double.parseDouble(acc);
                                if(accNumber!=0) {
                                    if(list.get(num).withdraw(accNumber))
                                    {
                                        blanceText.setText(""+list.get(num).balance);
                                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                                        alert.setHeaderText("取款成功");
                                        alert.showAndWait();
                                    }
                                    else
                                    {
                                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                                        alert.setHeaderText("取款失败");
                                        alert.showAndWait();
                                    }
                                }
                            }
                            else
                            {
                                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("请勾选操作方式");
                                alert.showAndWait();
                            }
                        }
                    });
                    userPane.add(OK,1,4);
                    Scene scene=new Scene(userPane);
                    userStage.setScene(scene);
                    userStage.setWidth(480);
                    userStage.setHeight(200);
                    userStage.show();
                }
                else
                {
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("PIN或密码错误，请重新输入");
                    alert.showAndWait();
                }
            }
        });
        Button siginButton=new Button("注册");
        siginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage s=new Stage();
                GridPane siginPane=new GridPane();
                Label tip1=new Label("请输入创建用户的PIN：");
                Label tip2=new Label("请输入创建用户的密码：");
                TextField Newuser=new TextField();
                PasswordField NewPassword=new PasswordField();
                NewPassword.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if(newValue.length()>6)//限制为6位
                            NewPassword.textProperty().setValue(oldValue);
                    }
                });
                Button OK=new Button("注册");
                siginPane.addRow(0,tip1,Newuser);
                siginPane.addRow(1,tip2,NewPassword);
                HBox hBox1=new HBox();
                Label accountKind=new Label("账户种类");
                ToggleGroup kind=new ToggleGroup();
                RadioButton checkAccount=new RadioButton("支票");
                RadioButton savingAccount=new RadioButton("储蓄");
                checkAccount.setToggleGroup(kind);
                savingAccount.setToggleGroup(kind);
                hBox1.getChildren().addAll(checkAccount,savingAccount);
                siginPane.addRow(2,accountKind);
                siginPane.addRow(2,hBox1);
                siginPane.add(OK,1,3);
                siginPane.setAlignment(Pos.CENTER);
                Scene Siginscene=new Scene(siginPane);
                s.setScene(Siginscene);
                s.setHeight(200);
                s.setWidth(480);
                s.show();
                OK.setOnAction(e->{
                    int flag=0;
                    Account temp=new Account();
                    //账户类型判断
                    if(checkAccount.isSelected())
                    {
                        temp=new CheckingAccount();
                        temp.balance=0;
                        flag=1;
                    }
                    else if(savingAccount.isSelected())
                    {
                        temp=new SavingAccount();
                        temp.balance=0;
                        flag=1;
                    }
                    else if(!savingAccount.isSelected()&&!checkAccount.isSelected())
                    {
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("请勾选账户类型");
                        alert.showAndWait();
                    }
                    if(flag==1) {
                        //设置账户的PIN和密码
                        temp.PIN = Newuser.getText();
                        temp.passward = NewPassword.getText();
                        list.add(temp);
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert1.setHeaderText("账户注册成功");
                        alert1.showAndWait();
                        s.close();
                    }
                });
            }
        });
        login.addRow(0,user,name);
        login.addRow(1,pass,password);
        HBox hBox=new HBox();
        hBox.getChildren().addAll(loginButton,siginButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        login.add(hBox,1,2);
        login.setAlignment(Pos.TOP_CENTER);
        pane.setTop(atm);
        pane.setCenter(login);
        BorderPane.setAlignment(login, Pos.CENTER);
        BorderPane.setAlignment(atm,Pos.CENTER);
        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ATM存取一体机");
        primaryStage.setWidth(500);
        primaryStage.setHeight(230);
        primaryStage.show();
    }
    public boolean sameStr(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        else{
            for(int i=0;i<s1.length();i++)
                if(s1.charAt(i)!=s2.charAt(i))
                    return false;
            return true;
        }
    }


}


class Account {
    protected String PIN;
    protected String passward;
    protected double balance;
    protected java.util.Date dateCreated;
    public Account() {
        dateCreated = new java.util.Date();
    }
    public Account(double Balance) {
        balance = Balance;
        dateCreated = new java.util.Date();
    }
    public double getBalance() {
        return balance;
    }
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    //存款
    public boolean deposit(double amount) {
        if(amount+balance>=10000)
            return false;
        else
        {
            balance+=amount;
            return true;
        }
    }
    //取款
    public boolean withdraw(double amount){
        if(balance-amount>=0)
        {
            balance-=amount;
            return true;
        }
        else
            return false;
    }

}
class CheckingAccount extends Account {
    private double overprotected = 100;
    @Override
    public boolean withdraw(double amount) {
        if(balance+overprotected-amount>=0&&balance-amount<0)
        {
            balance-=(amount+10);
            return true;
        }
        else if(balance-amount>=0)
        {
            balance-=amount;
            return true;
        }
        else
        {
            return false;
        }

    }



}

class SavingAccount extends Account {
    private static double Rate=0.02;//利率是个定值
    private static double punishment;//罚款
    public static double getRate() {
        return Rate;
    }
    public static void setRate(double rate) {
        Rate = rate;
    }

    public static void setPunishment(double punishment) {
        SavingAccount.punishment = punishment;
    }

    public static double getPunishment() {
        return punishment;
    }

    @Override
    public boolean withdraw(double amount) {

        if(balance-amount>=0)
        {
            balance -= amount;
            return true;
        }
        else return false;
    }
    public void rate(){
        Date now=new java.util.Date();
        double ratenum=this.balance*Rate*(now.getTime()-dateCreated.getTime())/1000/60/60/24;
        this.balance+=ratenum;

    }
}
