package com.example.demo3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;


import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    @SuppressWarnings("static-access")
    public void start (Stage primaryStage) {

            int BorderWidth = 350;
            primaryStage.setTitle("Kalkulator");

            GridPane glownyBorderPane = new GridPane();
            glownyBorderPane.setHgap(1);

            Scene scene = new Scene(glownyBorderPane, 200, 500);

            GridPane UpgridPane = new GridPane();
            GridPane MidgridPane = new GridPane();
            GridPane DowngridPane = new GridPane();

            glownyBorderPane.add(UpgridPane, 0, 0);
            glownyBorderPane.setMargin(UpgridPane, new Insets(0, 15, 15, 0));
            glownyBorderPane.add(MidgridPane, 0, 1);
            glownyBorderPane.setMargin(MidgridPane, new Insets(0, 15, 15, 0));
            glownyBorderPane.add(DowngridPane, 0, 4);
            glownyBorderPane.setMargin(DowngridPane, new Insets(15, 15, 0, 0));

            Label CMethod = new Label();
            CMethod.setGraphic(new Label("Metoda Obliczeń: "));
            CMethod.getGraphic().setStyle("-fx-background-color: #f4f4f4;");
            CMethod.getStyleClass().add("title");
            CMethod.setPadding(new Insets(-50, -20, 0, 0));

            Label Data = new Label();
            Data.setGraphic(new Label("Dane: "));
            Data.getGraphic().setStyle("-fx-background-color: #f4f4f4;");
            Data.getStyleClass().add("title");
            Data.setPadding(new Insets(-60, -20, 0, 0));

            Label Calc = new Label();
            Calc.setGraphic(new Label("Wyniki: "));
            Calc.getGraphic().setStyle("-fx-background-color: #f4f4f4;");
            Calc.getStyleClass().add("title");
            Calc.setPadding(new Insets(-50, -20, 0, 0));

            RadioButton NtB = new RadioButton("od Netto do Brutto");
            RadioButton BtN = new RadioButton("od Brutto do Netto");
            RadioButton MatchVat = new RadioButton("Dopasuj do kwoty Vat");
            ToggleGroup CMethods = new ToggleGroup();

            Text NumText = new Text("Wartość bazowa:");   TextField NumField = new TextField();
            Text VatText = new Text("Stawka Vat:");
            ChoiceBox<String> VatBox = new ChoiceBox<String> (
                    FXCollections.observableArrayList(
                            "5%", "23%"
                    ));

            Button ob = new Button("OBLICZ");
            ob.setMinWidth(100);
            Button zb = new Button("zamknij");
            zb.setMinWidth(100);


            Text RNettoText = new Text("Netto:"); Text RNettoNum = new Text("0");
            Text RVatText = new Text("Vat:"); Text RVatNum = new Text("0");
            Text RBruttoText = new Text("Brutto:"); Text RBruttoNum = new Text("0");

            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                            double Netto = 0;
                            double Brutto = 0;
                            double VatVal = 0;
                            RadioButton sbutton = (RadioButton)CMethods.getSelectedToggle();
                            double Vat = VatBox.getValue().equals("23%") ? 23 / 100.0 : 5 / 100.0;
                            double CalcVal = Integer.parseInt(NumField.getText());
                            if (sbutton.getText() == "od Brutto do Netto"){
                                    Brutto = CalcVal;
                                    Netto = CalcVal * (1 - Vat);
                                    VatVal = CalcVal * Vat;
                            }
                            else if (sbutton.getText() == "od Netto do Brutto") {
                                    Brutto = CalcVal * (1 + Vat);
                                    Netto = CalcVal;
                                    VatVal = CalcVal * Vat;
                            }
                            else if(sbutton.getText() == "Dopasuj do kwoty Vat"){
                                    Brutto = CalcVal / Vat + CalcVal;
                                    Netto = CalcVal / Vat;
                                    VatVal = CalcVal;
                            }
                            else {
                                    System.out.println("nie wybrano radiobutton");
                            }
                            RNettoNum.setText(String.valueOf(Math.floor(Netto * 100) / 100));
                            RVatNum.setText(String.valueOf(Math.floor(VatVal * 100) / 100) + " @ " + VatBox.getValue());
                            RBruttoNum.setText(String.valueOf(Math.floor(Brutto * 100) / 100));
                    }
            };
            ob.setOnAction(event);

            NtB.setToggleGroup(CMethods);
            BtN.setToggleGroup(CMethods);
            MatchVat.setToggleGroup(CMethods);

            UpgridPane.setVgap(5);
            UpgridPane.setHgap(5);

            MidgridPane.setVgap(5);
            MidgridPane.setHgap(5);

            DowngridPane.setVgap(5);
            DowngridPane.setHgap(35);

            UpgridPane.setPadding(new Insets(15));
            UpgridPane.setLayoutX(100);
            UpgridPane.setLayoutY(100);
            UpgridPane.setMinSize(BorderWidth, 50);

            MidgridPane.setPadding(new Insets(15));
            MidgridPane.setLayoutX(100);
            MidgridPane.setLayoutY(200);
            MidgridPane.setMinSize(BorderWidth, 50);

            glownyBorderPane.add(zb, 1, 2);
            glownyBorderPane.add(ob, 0,2);
            glownyBorderPane.setMargin(zb, new Insets(0, 0, 0, -115));

            DowngridPane.setPadding(new Insets(15));
            DowngridPane.setLayoutX(100);
            DowngridPane.setLayoutY(300);
            DowngridPane.setMinSize(BorderWidth, 150);

            UpgridPane.add(NtB, 0, 0);
            UpgridPane.add(BtN, 0, 1);
            UpgridPane.add(MatchVat, 0, 2);

            MidgridPane.add(NumText, 0, 0);
            MidgridPane.add(NumField, 1, 0);
            MidgridPane.add(VatText, 0, 2);
            MidgridPane.add(VatBox, 1, 2);

            DowngridPane.add(RNettoText, 0, 0); DowngridPane.add(RNettoNum, 4, 0);
            DowngridPane.add(RVatText, 0, 1); DowngridPane.add(RVatNum, 5, 1);
            DowngridPane.add(RBruttoText, 0, 2); DowngridPane.add(RBruttoNum, 4, 2);

            glownyBorderPane.setPadding(new Insets(20, 10, 10, 10));

            CMethod.setPrefWidth(100);
            Data.setPrefWidth(100);
            UpgridPane.add(CMethod, 0, 0);
            MidgridPane.add(Data,0, 0);
            DowngridPane.add(Calc, 0, 0);

            UpgridPane .setStyle("-fx-border-style: solid inside;");
            UpgridPane .setStyle("-fx-border-width: 1;");
            UpgridPane .setStyle("-fx-border-insets: 1;");
            UpgridPane .setStyle("-fx-border-radius: 1;");
            UpgridPane .setStyle("-fx-border-color: black;");

            MidgridPane .setStyle("-fx-border-style: solid inside;");
            MidgridPane .setStyle("-fx-border-width: 1;");
            MidgridPane .setStyle("-fx-border-insets: 1;");
            MidgridPane .setStyle("-fx-border-radius: 1;");
            MidgridPane .setStyle("-fx-border-color: gray;");

            DowngridPane .setStyle("-fx-border-style: solid inside;");
            DowngridPane .setStyle("-fx-border-width: 1;");
            DowngridPane .setStyle("-fx-border-insets: 1;");
            DowngridPane .setStyle("-fx-border-radius: 1;");
            DowngridPane .setStyle("-fx-border-color: black;");

            primaryStage.setScene(scene);
            primaryStage.setMinHeight(250);
            primaryStage.setMinWidth(390);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}