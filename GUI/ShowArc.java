package GUI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
public class ShowArc extends Application {
    @Override
    public void start(Stage primaryStage){
        Arc arc1=new Arc(150,100,80,80,30,35);
        arc1.setFill(Color.WHITE);
        arc1.setType(ArcType.ROUND);
        arc1.setStroke(Color.BLACK);

        Arc arc2=new Arc(150,100,80,80,30+90,35);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);

        Arc arc3=new Arc(150,100,80,80,30+180,35);
        arc3.setFill(Color.WHITE);
        arc3.setType(ArcType.CHORD);
        arc3.setStroke(Color.BLACK);

        Arc arc4=new Arc(150,100,80,80,30+270,35);
        arc4.setFill(Color.WHITE);
        arc4.setType(ArcType.CHORD);
        arc4.setStroke(Color.BLACK);

        Group group=new Group();//group不是抽象类
        group.getChildren().addAll(
                new Text(210,40,"arc1:round"),arc1,
                new Text(20,40,"arc2:open"),arc2,
                new Text(20,170,"arc3:chord"),arc3,
                new Text(210,170,"arc4:chord"),arc4);
        Scene scene=new Scene(new BorderPane(group),300,200);
        primaryStage.setTitle("ShowArc");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
