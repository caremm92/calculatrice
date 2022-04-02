package com.example.calculatrice;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import parserinitial.parser.*;

import java.io.*;
import java.util.*;

/**
 * La calculatrice s'utilise en selectionnant du texte et le solveur s'active automatiquement.
 * Un fichier d'exemples se trouve dans : resources/com.example.calculatrice/example.txt
 * Le solveur est issu de ParnerNG qui se trouve sur github.
 * 
 */

public class Calculatrice extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculatrice");                              //Titre du programme

        AnchorPane ap = new AnchorPane();

        /**
         * Creation de 2 menus "File" et "Help"
         */

        Menu fileMenu = new Menu("File");                                //Creation du menu "File"
        MenuItem item1 = new MenuItem("Open");                           //Creation des sous menus correspondants
        MenuItem item5 = new MenuItem("Exit");
        fileMenu.getItems().addAll(item1, item5);                          //On attache les sous menus au menu "File"

        Menu helpMenu = new Menu("Help");                                //Creation du menu "Help"
        MenuItem itemh1 = new MenuItem("Documentation");                 //Creation du sous menu "Documentation" pour avoir l'aide
        helpMenu.getItems().addAll(itemh1);                                 //On attache le sous menus au menu "Help"

        MenuBar menuBar = new MenuBar();                                    //Creation de la barre de menu
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        menuBar.setTranslateX(0);                                           //Attache de la barre a la position (0,0) de l'objet "anchorpane"
        menuBar.setTranslateY(0);

        /**
         *Creation d'une zone de texte
         */

        TextArea textArea= new TextArea();                                  //Creation d'une textarea où l'utilisateur mets ses formules à résoudre
        textArea.setPadding(new Insets(23));                             //Positionnement de cette zone 23 pixels en dessous du haut de l'anchorpane
        textArea.setWrapText(true);                                         //pour eviter que le menu et la zone de texte se chevauchent

        /**
         *Definitions du comportement des sous menus
         */

        item1.setOnAction((ActionEvent t) -> {                              //sous menu "Open"
            final FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);           // une boite de dialogue s'affiche et le fichier choisi
            try {                                                           // est reference par "file"
                Scanner input = new Scanner(file);                          // lit le contenu du fichier
                while (input.hasNext()) {
                    textArea.appendText(input.nextLine() + '\n');        // Lit le fichier ligne a ligne et met un caractere
                }                                                           // de fin de chaine au bout de la ligne
                input.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found: " + file);              // Affiche un message si le fichier n'est pas trouve
            } catch (Exception ex) {
                System.out.println(ex.getMessage());                        // Affiche un message pour les autres exceptions
            }
        });
        item5.setOnAction((ActionEvent t) -> {                              // sous menu "Exit"
            System.exit(0);                                           // sort du programme
        });
        itemh1.setOnAction((ActionEvent t) -> {                             // sous menu "Documentation"
            AnchorPane ap2 = new AnchorPane();                              // créé une nouvelle zone de texte pour afficher l'aide
            TextArea textArea2= new TextArea();
            ap2.getChildren().addAll(textArea2);
            Scene scene2 = new Scene(ap2);
            Stage secondstage= new Stage();
            secondstage.setScene(scene2);
            secondstage.show();

            String filename ="src/main/resources/aidecalc.txt";             // fichier d'aide
            try {
                Scanner input = new Scanner(new File(filename));            // lit le contenu du fichier
                while (input.hasNext()) {
                    textArea2.appendText(input.nextLine() + '\n');       // Lit le fichier ligne a ligne et met un caractere
                }                                                           // de fin de chaine au bout de la ligne
                input.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found: " + filename);          // Affiche un message si le fichier n'est pas trouve
            } catch (Exception ex) {
                System.out.println(ex.getMessage());                        // Affiche un message pour les autres exceptions
            }
        });

        /**
         *Creation des boutons et leur comportement
         */

        Button button1 = new Button("+");
        Button button2 = new Button("-");
        Button button3 = new Button("*");
        Button button4 = new Button("/");
        Button button5 = new Button("abs");
        Button button6 = new Button("ceil");
        Button button7 = new Button("floor");
        Button button8 = new Button("cos");
        Button button9 = new Button("sin");
        Button button10 = new Button("tan");

        GridPane gridPane = new GridPane();                                // creation d'une grille pour les boutons.
        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 3, 0, 1, 1);
        gridPane.add(button5, 0, 1, 1, 1);
        gridPane.add(button6, 1, 1, 1, 1);
        gridPane.add(button7, 2, 1, 1, 1);
        gridPane.add(button8, 0, 2, 1, 1);
        gridPane.add(button9, 1, 2, 1, 1);
        gridPane.add(button10, 2, 2, 1, 1);

        textArea.appendText("r=4;r*5"+'\n');                            // texte pour montrer un exemple.

        /**
         *Evenements associes aux boutons
         */

        EventHandler<ActionEvent> eventbutton1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("+");}
        };
        EventHandler<ActionEvent> eventbutton2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("-");}
        };
        EventHandler<ActionEvent> eventbutton3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("*");}
        };
        EventHandler<ActionEvent> eventbutton4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("/");}
        };
        EventHandler<ActionEvent> eventbutton5 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("abs()");}
        };
        EventHandler<ActionEvent> eventbutton6 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("ceil()");}
        };
        EventHandler<ActionEvent> eventbutton7 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("floor()");}
        };
        EventHandler<ActionEvent> eventbutton8 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("cos()");}
        };
        EventHandler<ActionEvent> eventbutton9 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("sin()");}
        };
        EventHandler<ActionEvent> eventbutton10 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){textArea.appendText("tan()");}
        };

        button1.setOnAction(eventbutton1);
        button2.setOnAction(eventbutton2);
        button3.setOnAction(eventbutton3);
        button4.setOnAction(eventbutton4);
        button5.setOnAction(eventbutton5);
        button6.setOnAction(eventbutton6);
        button7.setOnAction(eventbutton7);
        button8.setOnAction(eventbutton8);
        button9.setOnAction(eventbutton9);
        button10.setOnAction(eventbutton10);


        /**
         *Lorsque le texte est sélectionné le résultat s'affiche
         */

        textArea.setOnMouseClicked(new EventHandler<Event>()
        {
            @Override
            public void handle(Event arg0)
            {
                String s;
                s= textArea.getSelectedText();
                MathExpression expr = new MathExpression(s);                    // initialisation du parser
                textArea.appendText("solution : "+expr.solve()+'\n');        // utilisation du parser
            }
        });

        /**
         *Creation de la scene
         */

        AnchorPane.setTopAnchor(menuBar,0.0);                           // positionnement des entités menu,aire de texte,
        AnchorPane.setLeftAnchor(textArea,0.0);                         // et grille de boutons
        AnchorPane.setBottomAnchor(gridPane,0.0);
        ap.getChildren().addAll(textArea,gridPane,menuBar);
        Scene scene = new Scene(ap, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
