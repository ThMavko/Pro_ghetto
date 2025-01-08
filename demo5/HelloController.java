package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class HelloController {

    @FXML
    private CheckBox cbby3;

    @FXML
    private CheckBox cbby5;

    @FXML
    private Button test;

    @FXML
    private TextField tfnumber;

    @FXML
    private ScatterChart<String, Number> scatterChart;  // ScatterChart con CategoryAxis per X

    // Dati per il grafico (memorizzati durante l'interazione con l'utente)
    private XYChart.Series<String, Number> series = new XYChart.Series<>();

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        // Eventuale logica per gestire l'azione sul TextField (quando si preme "Enter")
    }

    @FXML
    void ontestbuttonclick(ActionEvent event) {
        // Recupera il numero inserito
        String input = tfnumber.getText();
        try {
            double number = Double.parseDouble(input);  // Converte l'input in un numero

            // Calcola la divisibilità per 3, 5 o entrambi
            String divisibility = checkDivisibility(number);

            // Aggiungi il dato al grafico
            addDataToChart(divisibility, number);

            // Mostra l'esito nei checkbox
            cbby3.setSelected(divisibility.contains("by 3"));
            cbby5.setSelected(divisibility.contains("by 5"));

        } catch (NumberFormatException e) {
            System.out.println("Per favore inserisci un numero valido.");
        }
    }

    private String checkDivisibility(double number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if (divisibleBy3 && divisibleBy5) {
            return "by 3 and 5";
        } else if (divisibleBy3) {
            return "by 3";
        } else if (divisibleBy5) {
            return "by 5";
        } else {
            return "neither";
        }
    }

    private void addDataToChart(String divisibility, double number) {
        // Aggiungi il dato al grafico come punto di dispersione
        series.getData().add(new XYChart.Data<>(divisibility, number));

        // Aggiorna il grafico
        scatterChart.getData().clear();  // Rimuove i dati precedenti
        scatterChart.getData().add(series);  // Aggiunge i nuovi dati
    }
}
