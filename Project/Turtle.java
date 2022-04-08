package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Turtle extends Application {
    //海龟的中心坐标
    double x=14;
    double y=14;
    //是否绘画的标志
    boolean flag=false;
    Pane pane=new Pane();
    @Override
    public void start(Stage primaryStage){


        //绘制坐标轴
        Label X=new Label("X");
        X.setLayoutX(670);
        X.setLayoutY(7);
        X.setFont(Font.font(20));
        Label Y=new Label("Y");
        Y.setLayoutX(7);
        Y.setLayoutY(380);
        Y.setFont(Font.font(20));
        Line lineX=new Line(7,7,670,7);
        Line Xright=new Line(670,7,663,0);
        Line Xleft=new Line(670,7,663,14);
        Line lineY=new Line(7,7,7,380);
        Line Yright=new Line(7,380,14,373);
        Line Yleft=new Line(7,380,0,373);
        lineX.setStroke(Color.BLACK);
        lineX.setStrokeWidth(2);
        lineY.setStroke(Color.BLACK);
        lineY.setStrokeWidth(2);
        pane.getChildren().addAll(lineX,lineY,Xleft,Xright,Yleft,Yright,X,Y);
        //绘制一个海龟
        Ellipse ellipse1 = new Ellipse(x,y,7,5);
        Circle circle1=new Circle(x+10,y,2.5);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        Circle circle2=new Circle(x,y-5,2.5);
        Circle circle3=new Circle(x,y+5,2.5);
        Circle circle4=new Circle(x-6,y-3,2.5);
        Circle circle5=new Circle(x-6,y+3,2.5);
        pane.getChildren().addAll(ellipse1,circle1,circle2,circle3,circle4,circle5);
        Scene scene=new Scene(pane);
        //在最底部添加一个输入框和提示和按钮来输入指令集合
        VBox tip=new VBox();
        Label label1=new Label("请输入");
        Label label2=new Label("命令集合");
        Label label3=new Label("s为start");
        Label label4=new Label("m为move");
        Label label5=new Label("e为end");
        Button OK=new Button("确认");
        tip.getChildren().addAll(label1,label2,label3,label4,label5);
        tip.setLayoutX(610);
        tip.setLayoutY(400);
        pane.getChildren().add(tip);
        TextArea commond=new TextArea();
        pane.getChildren().add(commond);
        commond.setPrefWidth(600);
        commond.setPrefHeight(280);
        commond.setLayoutX(0);
        commond.setLayoutY(400);

        OK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //对文本框中的语句进行处理
                String commondText=commond.getText();
                String[] commondCollection=commondText.split("\n");
//                System.out.println(commondText);
                for(int i=0;i<commondCollection.length;i++)
                {
                    if(commondCollection[i].equals("s")){
                        flag=true;
                    }
                    else if(commondCollection[i].equals("e")){
                        flag=false;
                    }
                    else if(commondCollection[i].charAt(0)=='m'){
                        if(flag==true){
                            String[] num=commondCollection[i].split(" ");
                            move(Double.parseDouble(num[1]),Double.parseDouble(num[2]));
                        }

                    }
                }
//                    if(commondText.charAt(i)=='\n')
//                        System.out.print("回车");
//                    else
//                        System.out.print(commondText.charAt(i));
            }
        });
        OK.setLayoutX(610);
        OK.setLayoutY(550);
        pane.getChildren().add(OK);
        //首先对界面的设置
        primaryStage.setScene(scene);
        primaryStage.setWidth(720);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Turtle");
        primaryStage.show();
    }
    public void move(double x,double y){
        Line temp=new Line(this.x,this.y,x,y);
        this.x=x;
        this.y=y;
        pane.getChildren().add(temp);
        Ellipse ellipse1 = new Ellipse(x,y,7,5);
        Circle circle1=new Circle(x+10,y,2.5);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        Circle circle2=new Circle(x,y-5,2.5);
        Circle circle3=new Circle(x,y+5,2.5);
        Circle circle4=new Circle(x-6,y-3,2.5);
        Circle circle5=new Circle(x-6,y+3,2.5);
        pane.getChildren().addAll(ellipse1,circle1,circle2,circle3,circle4,circle5);
    }
}
