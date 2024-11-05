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

            Scene scene = new Scene(glownyBorderPane, 200, 600);

            GridPane UpgridPane = new GridPane();
            GridPane MidgridPane = new GridPane();
            GridPane DowngridPane = new GridPane();

            glownyBorderPane.add(UpgridPane, 0, 0);
            glownyBorderPane.setMargin(UpgridPane, new Insets(0, 15, 15, 0));
            glownyBorderPane.add(MidgridPane, 0, 2);
            glownyBorderPane.setMargin(MidgridPane, new Insets(0, 15, 15, 0));
            glownyBorderPane.add(DowngridPane, 0, 4);
            glownyBorderPane.setMargin(DowngridPane, new Insets(0, 15, 0, 0));

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
            NumField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
            Text VatText = new Text("Stawka Vat:");
            ChoiceBox<String> VatBox = new ChoiceBox<String> (
                    FXCollections.observableArrayList(
                            "5%", "23%"
                    ));

            Text RNettoText = new Text("Netto:"); Text RNettoNum = new Text("8");
            Text RVatText = new Text("Vat:"); Text RVatNum = new Text("8");
            Text RBruttoText = new Text("Brutto:"); Text RBruttoNum = new Text("8");

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

            DowngridPane.setPadding(new Insets(15));
            DowngridPane.setLayoutX(100);
            DowngridPane.setLayoutY(300);
            DowngridPane.setMinSize(BorderWidth, 50);

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
            MidgridPane .setStyle("-fx-border-color: black;");

            DowngridPane .setStyle("-fx-border-style: solid inside;");
            DowngridPane .setStyle("-fx-border-width: 1;");
            DowngridPane .setStyle("-fx-border-insets: 1;");
            DowngridPane .setStyle("-fx-border-radius: 1;");
            DowngridPane .setStyle("-fx-border-color: black;");

            primaryStage.setScene(scene);
            primaryStage.setMinHeight(250);
            primaryStage.setMinWidth(400);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}