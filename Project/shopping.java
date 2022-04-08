package Project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class shopping extends Application{
    int num1=0,num2=0, num3=0;
    double taxpercent=0.05;
    @Override
    public void start(Stage primaryStage)
    {
        Label l1=new Label("商品");
        Label l2=new Label("价格");
        Label l3=new Label("数量");
        Button sub1=new Button("-");
        Button sub2=new Button("-");
        Button sub3=new Button("-");
        Button plus1=new Button("+");
        Button plus2=new Button("+");
        Button plus3=new Button("+");
        Label i1=new Label("苹果");
        Label i2=new Label("栗子");
        Label i3=new Label("香蕉");
        TextField p1=new TextField("14");
        TextField p2=new TextField("15");
        TextField p3=new TextField("16");
        TextField t1=new TextField(num1+"");
        TextField t2=new TextField(num2+"");
        TextField t3=new TextField(num3+"");
        GridPane pane=new GridPane();
        pane.setVgap(10);
        pane.setHgap(50);
        t1.setPrefColumnCount(3);
        t2.setPrefColumnCount(3);
        t3.setPrefColumnCount(3);
        pane.add(l1,0,0);pane.add(l2,1,0);pane.add(l3,2,0);
        pane.add(i1, 0, 1);pane.add(p1,1,1);pane.add(t1,2,1);pane.add(sub1,3,1);pane.add(plus1,4,1);
        pane.add(i2, 0, 2);pane.add(p2,1,2);pane.add(t2,2,2);pane.add(sub2,3,2);pane.add(plus2,4,2);
        pane.add(i3, 0, 3);pane.add(p3,1,3);pane.add(t3,2,3);pane.add(sub3,3,3);pane.add(plus3,4,3);
        p1.setPrefColumnCount(3);
        p2.setPrefColumnCount(3);
        p3.setPrefColumnCount(3);
        Label s=new Label(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                Double.parseDouble(p3.getText())*num3+"");
        plus1.setOnAction(e -> {
            num1++;
            t1.setText(num1+"");
            s.setText(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                    Double.parseDouble(p3.getText())*num3+"");
        });
        plus2.setOnAction(e -> {
            num2++;
            t2.setText(num2+"");
            s.setText(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                    Double.parseDouble(p3.getText())*num3+"");
        });
        plus3.setOnAction(e -> {
            num3++;
            t3.setText(num3+"");
            s.setText(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                    Double.parseDouble(p3.getText())*num3+"");
        });
        sub1.setOnAction(e -> {
            if(num1>0)  num1--;
            t1.setText(num1+"");
            s.setText(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                    Double.parseDouble(p3.getText())*num3+"");
        });
        sub2.setOnAction(e -> {
            if(num2>0)  num2--;
            t2.setText(num2+"");
            s.setText(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                    Double.parseDouble(p3.getText())*num3+"");
        });
        sub3.setOnAction(e -> {
            if(num3>0)  num3--;
            t3.setText(num3+"");
            s.setText(+Double.parseDouble(p1.getText())*num1+Double.parseDouble(p2.getText())*num2+
                    Double.parseDouble(p3.getText())*num3+"");
        });
        TextField price=new TextField();
        TextField  tax=new TextField();
        TextField total=new TextField();
        price.setPrefColumnCount(5);
        tax.setPrefColumnCount(5);
        total.setPrefColumnCount(5);
        Button pay=new Button("付款");

        pane.addRow(4,new Label("总计价："),s);
        pane.add(pay,0,5);
        GridPane newpane=new GridPane();
        Stage stage=new Stage();
        Label pri=new Label("总商品价格");
        Label ta=new Label("总税额");
        Label tot=new Label("总计");

        newpane.add(pri, 0, 0);newpane.add(ta,0,1);newpane.add(tot, 0, 2);
        newpane.add(price, 1, 0);newpane.add(tax,1,1);newpane.add(total, 1, 2);
        Button pay1=new Button("付款");
        newpane.add(pay1,0, 2);
        Scene newscene=new Scene(newpane,200,200);
        stage.setTitle("支付界面");
        stage.setScene(newscene);
        pay.setOnAction(e->{
            Stage finalstage=new Stage();
            Label t=new Label("恭喜你！支付成功！");
            BorderPane a=new BorderPane();
            a.setCenter(t);
            Scene b=new Scene(a,100,100);
            finalstage.setTitle( "支付成功");
            finalstage.setScene(b);
            finalstage.setWidth(200);
            finalstage.setHeight(100);
            finalstage.show();
        });
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("商品列表");
        primaryStage.setScene(scene);
        primaryStage.setHeight(400);
        primaryStage.setWidth(550);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
