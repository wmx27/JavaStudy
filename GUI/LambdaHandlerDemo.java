package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class LambdaHandlerDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Text text1=new Text(40,40,"programming");
        Pane pane=new Pane(text1);
        pane.setPadding(new Insets(10,10,10,10));
        Button b1=new Button("Up");
        Button b2=new Button("Down");
        Button b3=new Button("Left");
        Button b4=new Button("Right");

        HBox hBox=new HBox(b1,b2,b3,b4);
        BorderPane borderPane=new BorderPane(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);
        borderPane.setBottom(hBox);

        b1.setOnAction(e->{
            text1.setY(text1.getY()>10? text1.getY()-5 : 10);});
        b2.setOnAction((e)->{
            text1.setY(text1.getY()<pane.getHeight()? text1.getY()+5:pane.getHeight());});
        b3.setOnAction((ActionEvent e)->{text1.setX(text1.getX()>0?text1.getX()-5:0);});
        b4.setOnAction(e->text1.setX(text1.getX()<pane.getWidth()-100? text1.getX()+5 : pane.getWidth()-100));
        Scene scene=new Scene(borderPane,400,350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
