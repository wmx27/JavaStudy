package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
public class NodeStyleRotateDemo extends Application{
    @Override
    public void start(Stage primaryStage){
        StackPane pane=new StackPane();
        Button btOk=new Button("ok");
        btOk.setStyle("-fx-border-color:blue;");
        pane.getChildren().add(btOk);

        pane.setRotate(45);//设置旋转角度 这时候注意是顺时针旋转的角度
        //setStyle()里面采用的方式是"-fx-属性:值; fx-属性:值; fx-属性:值;"这样的类似与CSS的方式
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        Scene scene=new Scene(pane,200,250);
        primaryStage.setTitle("NodeStyleRotateDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
