package GUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.shape.Arc;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
public class Test extends Application{


    @Override
    public void start(Stage primaryStage){
        Arc arc = new Arc();
        arc.setRadiusX(50);
        arc.setRadiusY(50);
        arc.setCenterX(50);
        arc.setCenterY(50);
        arc.setStroke(Color.GREEN);
        arc.setFill(Color.BLACK);
        arc.setStartAngle(0);
        arc.setLength(180);
        arc.setType(ArcType.OPEN);
        Group g=new Group(arc);
        Scene scene=new Scene(g);
        Pane p=new Pane(new Polygon());
        Scene s=new Scene(p,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("start was invoked ");
    }
    public Test(){
        System.out.println("Test was invoked");
    }
    public static void main(String[] args) {
        System.out.println("main was invoked");
        Application.launch(args);
    }

}
