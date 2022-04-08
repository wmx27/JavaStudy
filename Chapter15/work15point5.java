package Chapter15;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class work15point5 extends Application {
    private double width=40;
    @Override
    public void start(Stage primarySstage){
        Button calculate=new Button("Calculate");
        TextField input=new TextField();
        TextField monthrate=new TextField();
        TextField years=new TextField();
        TextField result=new TextField();
        calculate.setOnAction(e->{
            double rate=Double.parseDouble(monthrate.getText());
            double input1=Double.parseDouble(input.getText());
            int year=Integer.parseInt(years.getText());
            result.setText(input1*Math.pow(1+rate/1200,year*12)+"");
        });
        input.setAlignment(Pos.BOTTOM_RIGHT);
        monthrate.setAlignment(Pos.BOTTOM_RIGHT);
        input.setAlignment(Pos.BOTTOM_RIGHT);
        years.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane pane=new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.add(new Label("Investment Amounut"),0,0);
        pane.add(new Label("Number Of years"),0,1);
        pane.add(new Label("Annual Interest Rate"),0,2);
        pane.add(new Label("Future value"),0,3);
        pane.add(input,1,0);
        pane.add(years,1,1);
        pane.add(monthrate,1,2);
        pane.add(result,1,3);
        pane.add(calculate,1,4);

        pane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(calculate,HPos.RIGHT);//注意setHalignment的不同
        Scene scene=new Scene(pane,450,200);
        primarySstage.setScene(scene);
        primarySstage.show();
    }
}
