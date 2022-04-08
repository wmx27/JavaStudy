package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ShowCircle extends Application{
    @Override
    public void start(Stage primaryStage){
        //构建一个圆
        Circle circle=new Circle();
        circle.setCenterX(50);
        circle.setCenterY(50);
        circle.setRadius(50);
//        circle.setStroke(Color.BLACK);
//        circle.setFill(Color.RED);
        circle.setStyle("-fx-Stroke:Black;-fx-fill:red;");//发现不区分大小写
        //将圆放置在pane上
        Pane pane=new Pane(circle);

        Scene scene=new Scene(pane,200,250);
        primaryStage.setTitle("圆在pane上");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
