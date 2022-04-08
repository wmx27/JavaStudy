package GUI;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import javafx.scene.shape.Polygon;

public class Showpolygon extends Application {
    @Override
    public void start(Stage primaryStage){

        Scene scene=new Scene(new MyPolygon(),400,400);
        primaryStage.setTitle("ShowPolygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class MyPolygon extends Pane{
    private void paint(){
        Polygon polygon=new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list=polygon.getPoints();
        double centerX=getWidth()/2,centerY=getHeight()/2;
        double radius=Math.min(getWidth(),getHeight())*0.4;

        for(int i=0;i<6;i++){
            list.add(centerX+radius*Math.cos(2 * i * Math.PI / 6));
            list.add(centerY-radius*Math.sin(2 * i * Math.PI / 6));
        }
        getChildren().clear();
        getChildren().add(polygon);
    }
    @Override
    public void setWidth(double width){
        System.out.println("使用了setWidth");
        super.setWidth(width);
        paint();
    }
    @Override
    public void setHeight(double height){
        System.out.println("使用了setHeight");
        super.setHeight(height);
        paint();
    }
}