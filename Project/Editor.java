package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Editor extends Application {
    File file1;
    int flag=0;
    TextArea textArea=new TextArea();
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane=new BorderPane();

        MenuBar end=new MenuBar();

        Menu file = new Menu("文件");
        Menu edit = new Menu("编辑");
        Menu type = new Menu("格式");

        MenuItem newFile= new MenuItem("新建");
            newFile.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    textArea.clear();
                    file1=null;
                }
            });

        MenuItem open   = new MenuItem("打开");
            open.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("打开所选文件");
                    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("文本文件","*.txt"));
                    file1=fileChooser.showOpenDialog(new Stage());
                    String s=readFile(file1);
                    textArea.setText(readFile(file1));
                    flag=1;
                }
            });

        MenuItem save   = new MenuItem("保存");
            save.setOnAction(e->
                {
                    if (flag == 0) {
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("保存文件");
                        fileChooser1.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                        file1 = fileChooser1.showSaveDialog(primaryStage);
                        if(file1 != null)//用户没有选中文件, 已经取消操作
                        {
                            writeFile(file1);
                            Alert warning = new Alert(Alert.AlertType.INFORMATION);
                            warning.setHeaderText("保存成功！");
                            warning.showAndWait();
                        }
                    }
                    else {
                        writeFile(file1);
                        Alert warning = new Alert(Alert.AlertType.INFORMATION);
                        warning.setHeaderText("保存成功！");
                        warning.showAndWait();
                    }
                });
        MenuItem copy   = new MenuItem("复制");
        copy.setOnAction(e->{
            textArea.copy();
        });
        MenuItem paste  = new MenuItem("粘贴");
        paste.setOnAction(e->{
            textArea.paste();
        });
        MenuItem cut    = new MenuItem("剪切");
        cut.setOnAction(e->{
            textArea.cut();
        });
        MenuItem tottal = new MenuItem("全选");
        tottal.setOnAction(e->{
            textArea.selectAll();
        });
        MenuItem delete = new MenuItem("删除");
        delete.setOnAction(e->{
            int start = textArea.getCaretPosition();
            int len   = textArea.getSelectedText().length();
            textArea.deleteText( start , start+len);
        });
        System.out.println(textArea.fontProperty());
        MenuItem cuti = new MenuItem("粗体");
        cuti.setOnAction(e->{
            int start = textArea.getCaretPosition();
            int len   = textArea.getSelectedText().length();
            textArea.setStyle("-fx-font-weight:bold");
        });
        MenuItem xiahua = new MenuItem("下划线");
        xiahua.setOnAction(e->{
        });
        MenuItem xieti = new MenuItem("斜体");
        xieti.setOnAction(e->{
            textArea.setStyle("-fx-font-style:italic");
        });
        file.getItems().addAll(newFile,open,save);
        edit.getItems().addAll(copy,paste,cut,tottal,delete);
        type.getItems().addAll(cuti,xieti,xiahua);
        end.getMenus().addAll(file,edit,type);

        borderPane.setTop(end);
        borderPane.setCenter(textArea);

        Scene scene=new Scene(borderPane,400,400);
        primaryStage.setTitle("文本编辑器");
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public String readFile(File f){
        StringBuffer s=new StringBuffer();
        try{
            Scanner input=new Scanner(f);
            while(input.hasNext())
                s.append(input.nextLine()+"\n");
        }
        catch (Exception ex){
        }
        return s.toString();
    }

    public void writeFile(File f) {
        try {
            PrintWriter printWriter = new PrintWriter(f);
            String r=textArea.getText();
            printWriter.write(r);
            printWriter.close();
        }
        catch(Exception ex){
        }
    }
}
