package com.example.calculatrice;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import parser.*;


//import javax.management.loading.*;

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
        item5.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });
        //Creating a text area
        TextArea textArea= new TextArea();
        textArea.setPadding(new Insets(23));
        textArea.setWrapText(true);



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

        textArea.appendText("this is some text");
        //String equation= textArea.getText();

        EventHandler<ActionEvent> eventbutton1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                textArea.appendText("+");
            }
        };
        EventHandler<ActionEvent> eventbutton2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                textArea.appendText("-");
            }
        };
        EventHandler<ActionEvent> eventbutton3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                textArea.appendText("*");
            }
        };
        EventHandler<ActionEvent> eventbutton4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                textArea.appendText("/");
            }
        };

        // when button is pressed
        button1.setOnAction(eventbutton1);
        button2.setOnAction(eventbutton2);
        button3.setOnAction(eventbutton3);
        button4.setOnAction(eventbutton4);


        textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent k) {
                if (k.getCode().equals(KeyCode.ENTER)) {
                    String equation = textArea.getText();
                    textArea.appendText(equation);
                    equation= "";
                }
            }
        });

        AnchorPane ap = new AnchorPane();
        AnchorPane.setTopAnchor(menuBar,0.0);
        AnchorPane.setLeftAnchor(textArea,0.0);
        AnchorPane.setBottomAnchor(hbox,0.0);
        ap.getChildren().addAll(textArea,hbox,menuBar);
        Scene scene = new Scene(ap, 400, 300);

        /*MathExpression expr = new MathExpression("r=4;r*5");
        System.out.println("result: " + expr.solve());*/

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
