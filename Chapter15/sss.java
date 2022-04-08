package Chapter15;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;

import javafx.util.Duration;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;



public class sss extends Application{

    static int perimeterSignOne=1;
    static int perimeterSignTwo=1;
    static int perimeterSignThree=1;//存储周长标记
    static int areaSignOne=1;
    static int areaSignTwo=1;//存储面积标记

    @Override
    public void start(Stage primaryStage){

        //将borderpane面板作为最大的父面板加入scene
        BorderPane borderpane=new BorderPane();

        //首先进行主面板布局设计

        //底部设计
        HBox hbox=new HBox(10);
        //RadioButton button1=new RadioButton("圆");
        RadioButton button2=new RadioButton("椭圆&圆");
        RadioButton button3=new RadioButton("矩形&正方形");
        RadioButton button4=new RadioButton("直线");
        RadioButton button5=new RadioButton("点");
        hbox.getChildren().addAll(button2,button3,button4,button5);
        hbox.setAlignment(Pos.CENTER);
        borderpane.setBottom(hbox);
        borderpane.setAlignment(hbox, Pos.BASELINE_CENTER);

        //左部设计
        VBox vbox1=new VBox(10);
        CheckBox button6=new CheckBox("含有填充");
        ComboBox<String> cbo1=new ComboBox<>();
        cbo1.getItems().addAll("null","green","pink","red","cyan","gray");
        cbo1.setValue("null");
        cbo1.setStyle("-fx-background-color:cyan");
        CheckBox button8=new CheckBox("含有边框");
        ComboBox<String> cbo2=new ComboBox<>();
        cbo2.getItems().addAll("null","green","pink","red","cyan","gray");
        cbo2.setValue("null");
        cbo2.setStyle("-fx-background-color:cyan");
        vbox1.getChildren().addAll(button6,cbo1,button8,cbo2);
        vbox1.setAlignment(Pos.CENTER);
        borderpane.setLeft(vbox1);
        Button buttonl=new Button("显示周长");
        Button buttons=new Button("显示面积");
        vbox1.getChildren().addAll(buttonl,buttons);

        //右部设计
        VBox vbox2=new VBox(7);
        Button button10=new Button("Enlarge");
        button10.setStyle("-fx-background-color:yellow;-fx-border-color:black;");
        Button button11=new Button("Shrink");
        button11.setStyle("-fx-background-color:Red;-fx-border-color:black;");
        Button button12=new Button("Delete");
        button12.setStyle("-fx-background-color:cyan;-fx-border-color:black;");
        Button button13=new Button("存入文件");
        button13.setStyle("-fx-background-color:pink;-fx-border-color:black;");
        Button button14=new Button("读取文件");
        button14.setStyle("-fx-background-color:pink;-fx-border-color:black;");
        vbox2.getChildren().addAll(button10,button11,button12,button13,button14);
        vbox2.setAlignment(Pos.CENTER);
        borderpane.setRight(vbox2);

        //顶部设计
        ImageView imageview=new ImageView("resources/画板x.jpeg");
        Pane pane1=new Pane();
        pane1.getChildren().add(imageview);
        //borderpane.setTop(pane);
        PathTransition pathtransition=new PathTransition(Duration.millis(3000),new Rectangle(490,180,230,10),pane1);
        pathtransition.setCycleCount(Timeline.INDEFINITE);
        pathtransition.play();
        BorderPane borderpanex=new BorderPane();
        Button button15=new Button("Pause or Play 动画");
        button15.setStyle("-fx-border-color:blue");
        borderpanex.setBottom(button15);
        borderpanex.setTop(pane1);
        borderpanex.setAlignment(button15, Pos.BOTTOM_CENTER);
        borderpane.setTop(borderpanex);

        //中心画板设计

        //各种图像原图的创建
        Ellipse ellipse=new Ellipse(300,700,5,5);
        Rectangle rectangle=new Rectangle(300,700,5,5);
        Line line=new Line(300,700,400,700);
        line.setStrokeWidth(6);
        ellipse.setStrokeWidth(6);
        rectangle.setStrokeWidth(6);
        ArrayList <Shape> list=new ArrayList<>();

        //Point pont=new Point(300,700);

        //画笔设计
        Circle circle=new Circle();
        circle.setRadius(10);
        circle.setFill(Color.RED);
        circle.setCenterX(500);
        circle.setCenterY(800);
        borderpane.getChildren().add(circle);

        //画笔驱动事件
        //各种基本图形的事件驱动设计
        circle.setOnMouseDragged(e->{
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());

            //ellipse=new Ellipse(300,700,5,5);
            if(button6.isSelected()==true&&cbo1.getValue()=="green") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.GREEN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStyle("-fx-fill:green");
                }
                if(button4.isSelected()==true) {
                    //line.setStyle("-fx-fill:green");
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="pink") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.PINK);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.PINK);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.PINK);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="red") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.RED);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.RED);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.RED);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="cyan") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.CYAN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.CYAN);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.CYAN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="gray") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.GRAY);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.GRAY);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.GRAY);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else {

            }

            if(button8.isSelected()==true&&cbo2.getValue()=="green") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.GREEN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.GREEN);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.GREEN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="pink") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.PINK);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.PINK);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.PINK);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="red") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.RED);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.RED);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.RED);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="cyan") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.CYAN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.CYAN);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.CYAN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="gray") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.GRAY);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.GRAY);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.GRAY);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else {

            }

            if(button2.isSelected()==true) {
                //ellipse.setCenterX((300+e.getX())/2);
                //ellipse.setCenterY((700+e.getY())/2);
                ellipse.setRadiusX((e.getX()-300)/2);
                ellipse.setRadiusY((e.getY()-700)/2);
                borderpane.getChildren().add(ellipse);
                list.add(ellipse);
            }
            else if(button3.isSelected()==true) {
                rectangle.setWidth((e.getX()-300)/2);
                rectangle.setHeight((e.getY()-700)/2);
                borderpane.getChildren().add(rectangle);
                list.add(rectangle);
            }
            else if(button4.isSelected()==true) {
                line.setEndX(e.getX());
                borderpane.getChildren().add(line);
                list.add(line);
            }
        });

        //圆和椭圆的移动
        ellipse.setOnMouseDragged(m->{
            ellipse.setCenterX(m.getX());
            ellipse.setCenterY(m.getY());
        });

        //矩形和正方形的移动
        rectangle.setOnMouseDragged(m->{
            rectangle.setX(m.getX());
            rectangle.setY(m.getY());
        });

        //直线的移动
        line.setOnMouseDragged(m->{
            double x=m.getX()-line.getStartX();
            double y=m.getY()-line.getStartY();
            line.setStartX(m.getX());
            line.setStartY(m.getY());
            line.setEndX(line.getEndX()+x);
            line.setEndY(line.getEndY()+y);
        });

        //按钮事件驱动设计

        //后期图像填充
        cbo1.setOnAction(e->{
            //"green","pink","red","cyan","gray"
            if(button6.isSelected()==true&&cbo1.getValue()=="green") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.GREEN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.GREEN);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.GREEN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="pink") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.PINK);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.PINK);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.PINK);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="red") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.RED);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.RED);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.RED);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="cyan") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.CYAN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.CYAN);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.CYAN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button6.isSelected()==true&&cbo1.getValue()=="gray") {
                if(button2.isSelected()==true) {
                    ellipse.setFill(Color.GRAY);
                }
                if(button3.isSelected()==true) {
                    rectangle.setFill(Color.GRAY);
                }
                if(button4.isSelected()==true) {
                    //line.setFill(Color.GRAY);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
        });

        //后期图像轮廓
        cbo2.setOnAction(e->{
            //"green","pink","red","cyan","gray"
            if(button8.isSelected()==true&&cbo2.getValue()=="green") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.GREEN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.GREEN);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.GREEN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="pink") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.PINK);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.PINK);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.PINK);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="red") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.RED);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.RED);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.RED);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="cyan") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.CYAN);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.CYAN);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.CYAN);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
            else if(button8.isSelected()==true&&cbo2.getValue()=="gray") {
                if(button2.isSelected()==true) {
                    ellipse.setStroke(Color.GRAY);
                }
                if(button3.isSelected()==true) {
                    rectangle.setStroke(Color.GRAY);
                }
                if(button4.isSelected()==true) {
                    line.setStroke(Color.GRAY);
                }
                if(button5.isSelected()==true) {
                    //ellipse.setFill(Color.GREEN);
                }
            }
        });

        //图像的扩大
        button10.setOnAction(e->{
            if(button2.isSelected()==true) {
                ellipse.setRadiusX(ellipse.getRadiusX()+4);
                ellipse.setRadiusY(ellipse.getRadiusY()+4);
            }
            else if(button3.isSelected()==true) {
                rectangle.setWidth(rectangle.getWidth()+4);
                rectangle.setHeight(rectangle.getHeight()+4);
            }
            else if(button4.isSelected()==true) {
                line.setEndX(line.getEndX()+7);
            }
        });

        //图像的缩小
        button11.setOnAction(e->{
            if(button2.isSelected()==true) {
                ellipse.setRadiusX(ellipse.getRadiusX()-4);
                ellipse.setRadiusY(ellipse.getRadiusY()-4);
            }
            else if(button3.isSelected()==true) {
                rectangle.setWidth(rectangle.getWidth()-4);
                rectangle.setHeight(rectangle.getHeight()-4);
            }
            else if(button4.isSelected()==true) {
                line.setEndX(line.getEndX()-7);
            }
        });

        //暂停或者播放动画
        button15.setOnAction(e->{
            if(pathtransition.getStatus()==Animation.Status.RUNNING) pathtransition.pause();
            else pathtransition.play();
            pathtransition.setRate(1);
        });

        //删除图像
        button12.setOnAction(e->{
            if(button2.isSelected()==true) {
                borderpane.getChildren().remove(ellipse);
            }
            else if(button3.isSelected()==true) {
                borderpane.getChildren().remove(rectangle);
            }
            else if(button4.isSelected()==true) {
                borderpane.getChildren().remove(line);
            }
            else if(button5.isSelected()==true) {
                //borderpane.getChildren().remove(ellipse);
            }
        });

        //计算并显示周长
        Text text1=new Text();
        Text text2=new Text();
        Text text3=new Text();
        buttonl.setOnAction(e->{
            if(button2.isSelected()==true&&perimeterSignOne==1) {
                double d1=2*Math.PI*ellipse.getRadiusY()+4*Math.abs(ellipse.getRadiusX()-ellipse.getRadiusY());
                double f1=new BigDecimal(d1).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                text1.setX(ellipse.getCenterX()-25);
                text1.setY(ellipse.getCenterY()-5);
                text1.setText(""+f1+"px");
                text1.setFill(Color.DODGERBLUE);
                borderpane.getChildren().add(text1);
                perimeterSignOne=0;
            }
            else {
                borderpane.getChildren().removeAll(text1);
                perimeterSignOne=1;
            }

            if(button3.isSelected()==true&&perimeterSignTwo==1) {
                double f2=new BigDecimal(2*(rectangle.getHeight()+rectangle.getWidth())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                text2.setX(rectangle.getX()-20+rectangle.getWidth()/2);
                text2.setY(rectangle.getY()+rectangle.getHeight()/2);
                text2.setText(""+f2+"px");
                text2.setFill(Color.DODGERBLUE);
                borderpane.getChildren().add(text2);
                perimeterSignTwo=0;
            }
            else {
                borderpane.getChildren().removeAll(text2);
                perimeterSignTwo=1;
            }

            if(button4.isSelected()==true&&perimeterSignThree==1) {
                double f3=new BigDecimal(line.getEndX()-line.getStartX()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                text3.setX((line.getStartX()+line.getEndX())/2-20);
                text3.setY(line.getEndY()-10);
                text3.setText(""+f3+"px");
                text3.setFill(Color.DODGERBLUE);
                borderpane.getChildren().add(text3);
                perimeterSignThree=0;
            }
            else {
                borderpane.getChildren().removeAll(text3);
                perimeterSignThree=1;
            }
        });

        //计算并显示面积
        Text text4=new Text();
        Text text5=new Text();
        buttons.setOnAction(e->{
            if(button2.isSelected()==true&&areaSignOne==1) {
                //System.out.println(ellipse.getRadiusY());System.out.print(ellipse.getRadiusX());
                double d2=Math.PI*ellipse.getRadiusX()*ellipse.getRadiusY();
                double f4=new BigDecimal(d2).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
                text4.setX(ellipse.getCenterX()-25);
                text4.setY(ellipse.getCenterY()-5);
                text4.setText(""+f4+"px");
                text4.setFill(Color.DODGERBLUE);
                borderpane.getChildren().add(text4);
                areaSignOne=0;
            }
            else {
                borderpane.getChildren().removeAll(text4);
                areaSignOne=1;
            }

            if(button3.isSelected()==true&&areaSignTwo==1) {
                double d3=rectangle.getHeight()*rectangle.getWidth();
                double f5=new BigDecimal(d3).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
                text5.setX(rectangle.getX()-20+rectangle.getWidth()/2);
                text5.setY(rectangle.getY()+rectangle.getHeight()/2);
                text5.setText(""+f5+"px");
                text5.setFill(Color.DODGERBLUE);
                borderpane.getChildren().add(text5);
                areaSignTwo=0;
            }
            else {
                borderpane.getChildren().removeAll(text5);
                areaSignTwo=1;
            }
        });

        //删除图像
        button12.setOnAction(e->{
            if(button2.isSelected()==true) borderpane.getChildren().removeAll(ellipse);
            else if(button3.isSelected()==true) borderpane.getChildren().removeAll(rectangle);
            else if(button4.isSelected()==true) borderpane.getChildren().removeAll(line);
            else {

            }
        });

        //保存入文件
        button13.setOnAction(e->{

            //for(int i=0;i<list.size();i++) System.out.println(list.get(i));
            File file=new File("resources/图像.txt");
            try {
                PrintWriter output=new PrintWriter(file);
                for(int i=0;i<list.size();i++) {
                    output.println(list.get(i));
                }
                output.close();
            }
            catch(IOException e1) {
                System.out.println("文件异常");
            }
        });

        //读取文件
        button14.setOnAction(e->{
            try {
                Scanner input=new Scanner(new File("resources/图像.txt"));
                while(input.hasNext()) {
                    String s=input.nextLine();

                    if(s.charAt(0)=='E') {
                        //Ellipse[centerX=300.0, centerY=700.0, radiusX=89.5, radiusY=66.0, fill=0x008000ff, stroke=0x00ffffff, strokeWidth=6.0]
                        ellipse.setCenterX(Double.parseDouble(s.substring(s.lastIndexOf("centerX")+8, s.lastIndexOf("centerX")+11)));
                        ellipse.setCenterY(Double.parseDouble(s.substring(31, 34)));
                        ellipse.setRadiusX(Double.parseDouble(s.substring(s.lastIndexOf("radiusX")+8, s.lastIndexOf("radiusY")-2)));
                        ellipse.setRadiusY(Double.parseDouble(s.substring(s.lastIndexOf("radiusY")+8, s.lastIndexOf("fill")-2)));
                        String ss1=s.substring(s.lastIndexOf("fill=")+5, s.lastIndexOf("fill=")+15);
                        String ss2=s.substring(s.lastIndexOf("stroke=")+7, s.lastIndexOf("stroke=")+17);
                        if(ss1.equals("0x008000ff"))	ellipse.setFill(Color.GREEN);
                        else if(ss1.equals("0xffc0cbff")) ellipse.setFill(Color.PINK);
                        else if(ss1.equals("0xff0000ff")) ellipse.setFill(Color.RED);
                        else if(ss1.equals("0x00ffffff")) ellipse.setFill(Color.CYAN);
                        else if(ss1.equals("0x808080ff")) ellipse.setFill(Color.GRAY);
                        else {

                        }
                        if(ss2.equals("0x008000ff"))	ellipse.setStroke(Color.GREEN);
                        else if(ss2.equals("0xffc0cbff")) ellipse.setStroke(Color.PINK);
                        else if(ss2.equals("0xff0000ff")) ellipse.setStroke(Color.RED);
                        else if(ss2.equals("0x00ffffff")) ellipse.setStroke(Color.CYAN);
                        else if(ss2.equals("0x808080ff")) ellipse.setStroke(Color.GRAY);
                        else {

                        }
                        borderpane.getChildren().add(ellipse);
                    }
                    else if (s.charAt(0)=='R') {
                        //Rectangle[x=478.0, y=625.0, width=85.0, height=82.0, fill=0x008000ff, stroke=0x00ffffff, strokeWidth=6.0]
                        rectangle.setX(Double.parseDouble(s.substring(12, 17)));
                        rectangle.setY(Double.parseDouble(s.substring(21, 26)));
                        rectangle.setWidth(Double.parseDouble(s.substring(s.lastIndexOf("width")+6, s.lastIndexOf("height")-2)));
                        rectangle.setHeight(Double.parseDouble(s.substring(s.lastIndexOf("height")+7, s.lastIndexOf("fill")-2)));
                        String ss1=s.substring(s.lastIndexOf("fill=")+5, s.lastIndexOf("fill=")+15);
                        String ss2=s.substring(s.lastIndexOf("stroke=")+7, s.lastIndexOf("stroke=")+17);
                        if(ss1.equals("0x008000ff"))	rectangle.setFill(Color.GREEN);
                        else if(ss1.equals("0xffc0cbff")) rectangle.setFill(Color.PINK);
                        else if(ss1.equals("0xff0000ff")) rectangle.setFill(Color.RED);
                        else if(ss1.equals("0x00ffffff")) rectangle.setFill(Color.CYAN);
                        else if(ss1.equals("0x808080ff")) rectangle.setFill(Color.GRAY);
                        else {

                        }
                        if(ss2.equals("0x008000ff"))	rectangle.setStroke(Color.GREEN);
                        else if(ss2.equals("0xffc0cbff")) rectangle.setStroke(Color.PINK);
                        else if(ss2.equals("0xff0000ff")) rectangle.setStroke(Color.RED);
                        else if(ss2.equals("0x00ffffff")) rectangle.setStroke(Color.CYAN);
                        else if(ss2.equals("0x808080ff")) rectangle.setStroke(Color.GRAY);
                        else {

                        }
                        borderpane.getChildren().add(rectangle);
                        //System.out.println(s.substring(34, 38));
                        //System.out.println(s.substring(47, 51));
                    }else if(s.charAt(0)=='L') {
                        //Line[startX=438.0, startY=761.0, endX=777.0, endY=761.0, stroke=0x00ffffff, strokeWidth=6.0]
                        line.setStartX(Double.parseDouble(s.substring(12, 17)));
                        line.setStartY(Double.parseDouble(s.substring(26, 31)));
                        line.setEndX(Double.parseDouble(s.substring(38, 41)));
                        line.setEndY(Double.parseDouble(s.substring(50, 53)));
                        String ss2=s.substring(s.lastIndexOf("stroke=")+7, s.lastIndexOf("stroke=")+17);
                        if(ss2.equals("0x008000ff"))	line.setStroke(Color.GREEN);
                        else if(ss2.equals("0xffc0cbff")) line.setStroke(Color.PINK);
                        else if(ss2.equals("0xff0000ff")) line.setStroke(Color.RED);
                        else if(ss2.equals("0x00ffffff")) line.setStroke(Color.CYAN);
                        else if(ss2.equals("0x808080ff")) line.setStroke(Color.GRAY);
                        else {

                        }
                        borderpane.getChildren().add(line);
                    }else {

                    }
                }
                input.close();
            }
            catch(IOException e1) {
                System.out.println("文件异常");
            }
        });

        //舞台搭建
        Scene scene=new Scene(borderpane,1000,1000);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GUi画板");
        primaryStage.show();
    }
    public static void main(String [] args) {
        Application.launch(args);
    }
}

