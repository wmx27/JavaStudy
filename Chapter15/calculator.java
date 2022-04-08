package Chapter15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.security.krb5.SCDynamicStoreConfig;

public class calculator extends Application {
    @Override
    public void start(Stage primaryStage){
        VBox vBox=new VBox(10);
        HBox line1=new HBox(5);
        HBox line2=new HBox(5);
        line1.setPadding(new Insets(10,10,0,10));
        TextField num1=new TextField();
        TextField num2=new TextField();
        TextField result=new TextField();
        num1.setAlignment(Pos.CENTER);
        num1.setPrefWidth(100);
        num2.setAlignment(Pos.CENTER);
        num2.setPrefWidth(100);
        result.setAlignment(Pos.CENTER);
        result.setPrefWidth(100);
        line1.getChildren().addAll(new Label("Number 1:"),num1,new Label("Number 2:"),num2,new Label("Result"),result);


        Button add=new Button("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setText(Double.parseDouble(num1.getText())+Double.parseDouble(num2.getText())+"");
            }
        });
        Button subtract=new Button("Subtract");
        subtract.setOnAction(e->{
            result.setText(Double.parseDouble(num1.getText())-Double.parseDouble(num2.getText())+"");
        });
        Button multiply=new Button("Multiply");
        multiply.setOnAction(e->{
            result.setText(Double.parseDouble(num1.getText())*Double.parseDouble(num2.getText())+"");
        });
        Button divide=new Button("Divide");
        divide.setOnAction(e->{
            result.setText(Double.parseDouble(num1.getText())/Double.parseDouble(num2.getText())+"");
        });

        line2.setAlignment(Pos.CENTER);
        vBox.getChildren().add(line1);
        vBox.getChildren().add(line2);
        vBox.setAlignment(Pos.CENTER);
        line2.getChildren().addAll(add,subtract,multiply,divide);
        Scene scene=new Scene(vBox,600,150);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
