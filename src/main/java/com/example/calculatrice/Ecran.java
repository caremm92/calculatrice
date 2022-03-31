package com.example.calculatrice;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import parserinitial.parser.*;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

//import javax.management.loading.*;

public class Ecran extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("com.example.calculatrice.Calculatrice");

        //Creating menu File
        Menu fileMenu = new Menu("File");
        //Creating menu Item
        MenuItem item5 = new MenuItem("Exit");
        //Adding all the menu items to the menu
        fileMenu.getItems().addAll(item5);

        //Creating menu Help
        Menu helpMenu = new Menu("Help");
        //Creating menu Items
        MenuItem itemh1 = new MenuItem("Documentation");
        //Adding all the menu items to the menu
        helpMenu.getItems().addAll(itemh1);


        //Creating a menu bar and adding menu to it.
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        menuBar.setTranslateX(0);
        menuBar.setTranslateY(0);
        item5.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });
        itemh1.setOnAction((ActionEvent t) -> {
            AnchorPane ap2 = new AnchorPane();
            TextArea textArea2= new TextArea();
            ap2.getChildren().addAll(textArea2);
            Scene scene2 = new Scene(ap2, 400, 300);
            Stage secondstage= new Stage();
            secondstage.setScene(scene2);
            secondstage.show();

            String filename ="C:\\Users\\ecarrega\\Documents\\javaproject\\calculatrice\\src\\main\\resources\\aidecalc.txt";

            try {
                // Create a buffered stream
                Scanner input = new Scanner(new File(filename));

                // Read a line and append the line to the text area
                while (input.hasNext()) {
                    textArea2.appendText(input.nextLine() + '\n');
                }
                input.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found: " + filename);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
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

        textArea.appendText("r=4;r*5"+'\n');
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

        //MathExpression expr = new MathExpression("r=4;r*5");

        /*textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent k) {
                if (k.getCode().equals(KeyCode.ENTER)) {
                    String equation = textArea.getSelectedText();
                    textArea.appendText(equation);
                    //textArea.appendText(expr.solve());
                    //equation= "";
                    System.out.println("result: " + textArea.getSelectedText());
                }
            }
        });*/

        textArea.setOnMouseClicked(new EventHandler<Event>()
        {
            @Override
            public void handle(Event arg0)
            {
                String s;
                s= textArea.getSelectedText();
                MathExpression expr = new MathExpression(s);
                textArea.appendText("solution : "+expr.solve()+'\n');
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
