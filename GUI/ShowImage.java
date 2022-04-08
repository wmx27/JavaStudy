package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class ShowImage extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane=new HBox(10);
        pane.setPadding(new Insets(5,5,5,5));

        Image image=new Image("src/图片.jpeg");
        ImageView imageView2=new ImageView(image);
        imageView2.setFitHeight(500);
        imageView2.setFitWidth(500);
        pane.getChildren().add(imageView2);


        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("图片");
        primaryStage.show();

    }


}
