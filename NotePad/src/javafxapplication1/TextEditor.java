/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author mohamed
 */
public class TextEditor extends Application {
    private Object openItem;

    @Override
    public void start(Stage primaryStage) {
        TextArea area = new TextArea();
        Menu file = new Menu("file");
        MenuItem item1 = new MenuItem("new");
        MenuItem item2 = new MenuItem("open...");
        MenuItem item3 = new MenuItem("save");
        
        MenuItem item4 = new MenuItem("exit");
        file.getItems().addAll(item1, item2, item3, new SeparatorMenuItem(), item4);
       // SeparatorMenuItem sep = new SeparatorMenuItem();
        Menu edit = new Menu("edit");
        MenuItem item5 = new MenuItem("cut");
        MenuItem item6 = new MenuItem("copy");

        MenuItem item7 = new MenuItem("paste");
        MenuItem item8 = new MenuItem("delete");
        MenuItem item9 = new MenuItem("select all");
        MenuItem item11 = new MenuItem("undo");


        edit.getItems().addAll(item11,new SeparatorMenuItem(),item5, item6, item7, item8, item9);
        Menu help = new Menu("help");
        MenuItem item10 = new MenuItem("about Notepad");

        help.getItems().addAll(item10);
        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(file, edit, help);
        BorderPane pane = new BorderPane();
        pane.setTop(bar);
        pane.setCenter(area);

      //  Button btn = new Button();
        //  btn.setText("Say 'Hello World'");
        item11.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.undo();
            }
        });
        item6.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.copy();
            }
        });
        item1.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.clear();
            }
        });
        item5.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.cut();
            }
        });
        item7.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.paste();
            }
        });
        item8.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.deleteText(area.getSelection());
            }
        });
        item9.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               area.selectAll();
            }
        });
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("this NodePad is made by Mohamed Kaoud");
        item10.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
           public void handle(ActionEvent event) {
               a.setAlertType(Alert.AlertType.INFORMATION);
               a.show();
            }
        });
        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
            }

        });
        
         item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open  File");
                fileChooser.showOpenDialog( primaryStage) ;

               
            }

        });
         item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("save   File");
                fileChooser.showOpenDialog( primaryStage) ;
               
            }

        });
        
        Scene scene = new Scene(pane, 300, 250, Color.BEIGE);

        primaryStage.setTitle("FX NotePad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
