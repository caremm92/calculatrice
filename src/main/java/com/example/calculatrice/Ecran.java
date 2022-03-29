package com.example.calculatrice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class Ecran extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("com.example.calculatrice.Calculatrice");

        //Creating a menu
        Menu fileMenu = new Menu("File");
        //Creating menu Items
        MenuItem item5 = new MenuItem("Exit");
        //Adding all the menu items to the menu
        fileMenu.getItems().addAll(item5);
        //Creating a menu bar and adding menu to it.
        MenuBar menuBar = new MenuBar(fileMenu);
        menuBar.setTranslateX(0);
        menuBar.setTranslateY(0);


        Button button1 = new Button("+");
        Button button2 = new Button("-");
        Button button3 = new Button("*");
        Button button4 = new Button("/");
     /*   Button button5 = new Button("abs");
        Button button6 = new Button("ceil");
        Button button7 = new Button("floor");
        Button button8 = new Button("cos");
        Button button9 = new Button("sin");
        Button button10 = new Button("tan");*/

        HBox hbox = new HBox(button1, button2, button3, button4);
        TextArea textArea= new TextArea();
        textArea.setPadding(new Insets(23));
        AnchorPane ap = new AnchorPane();
        AnchorPane.setTopAnchor(menuBar,0.0);
        AnchorPane.setLeftAnchor(textArea,0.0);
        AnchorPane.setBottomAnchor(hbox,0.0);
        ap.getChildren().addAll(textArea,hbox,menuBar);
        Scene scene = new Scene(ap, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
