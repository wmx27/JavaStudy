package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class FontDemo extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane=new Pane();
        Circle circle=new Circle();
        circle.setStyle("-fx-fill:red;-fx-stroke:black;");
        circle.setRadius(50);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        //pane.getChildren().add(circle);

        Label label=new Label("JavaFX");
        label.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,20));
        pane.getChildren().addAll(circle,label);//发现添加的顺序跟层有关 越往后 越往上

        Scene scene=new Scene(pane);
        primaryStage.setTitle("FontDemo");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
