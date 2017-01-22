/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_per_hand;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author SenfDietze
 */
public class Calculator_Per_Hand extends Application {

    TextField txtnum1, txtnum2;
    Button btnadd, btnsub, btndiv, btnmul, btnclear;
    Label lblanswer;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

// make the controls
        txtnum1 = new TextField();
        txtnum2 = new TextField();
        btnadd = new Button("+");
        btnsub = new Button("-");
        btnmul = new Button("*");
        btndiv = new Button("+");
        btnclear = new Button("Clear");
        lblanswer = new Label("?");
        // center text in label
        lblanswer.setAlignment(Pos.CENTER);
        //apply ccs-like style to label (yes, youcan);
        lblanswer.setStyle("-fx-border-color: #000; fx-padding: ");
        //put container 
        root.setAlignment(Pos.CENTER);
        //setspacing between controls in grid
        root.setHgap(10);
        root.setVgap(10);
        //add to gris cell bycell
        root.add(btnadd, 0, 0);
        root.add(btnsub, 1, 0);
        root.add(btnmul, 0, 1);
        root.add(btndiv, 1, 1);
        root.add(txtnum1, 0, 2);
        root.add(txtnum2, 1, 2);

        //last 2 row´s span across 2 columns
        //col,rol, colspan, rowspan
        root.add(lblanswer, 0, 3, 2, 1);
        root.add(lblanswer, 0, 4, 2, 1);

        setWidths();

        attachCode();

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mathtastic 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setWidths() {

        txtnum1.setPrefWidth(70);
        txtnum2.setPrefWidth(70);
        btnadd.setPrefWidth(70);
        btnsub.setPrefWidth(70);
        btnmul.setPrefWidth(70);
        btndiv.setPrefWidth(70);
        btnclear.setPrefWidth(70);
        lblanswer.setPrefWidth(150);

    }

    public void attachCode() {

        btnadd.setOnAction(event -> btncode(event));
        btnsub.setOnAction(event -> btncode(event));
        btnmul.setOnAction(event -> btncode(event));
        btndiv.setOnAction(event -> btncode(event));
        btnclear.setOnAction(event -> btncode(event));

    }

    public void btncode(ActionEvent event) {

        int num1;
        int num2;
        int answer;
        char symbol;

        if (event.getSource() == btnclear) {

            txtnum1.setText("");
            txtnum2.setText("");
            txtnum2.setText("?");
            txtnum2.requestFocus();
            return;
        }
        num1 = Integer.parseInt(txtnum1.getText());
        num2 = Integer.parseInt(txtnum2.getText());
        if (event.getSource() == btnadd) {
            symbol = '+';
            answer = num1 + num2;
        } else if (event.getSource() == btnsub) {

            symbol = '-';
            answer = num1 - num2;

        } else if (event.getSource() == btnmul) {

            symbol = 'x';
            answer = num1 * num2;

        } else{
            symbol='/';
            answer = num1/num2;
        }
        
        //Zeigt das Ergebnis im AnswerLabel an
        lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);
                        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
