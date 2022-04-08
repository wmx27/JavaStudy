package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class ShowCircleCentered extends Application{
    @Override
    public void start(Stage primaryStage){
        Circle circle=new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.ORANGE);
        Pane pane=new Pane();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        pane.getChildren().add(circle);
        Scene scene=new Scene(pane,500,400);
        primaryStage.setTitle("绑定圆在屏幕中心");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
