package com.example.demo5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.ScatterChart;
import javafx.stage.Stage;

public class ScatterChartExample extends Application {

    @Override
    public void start(Stage stage) {
        // Crea gli assi per il ScatterChart
        CategoryAxis xAxis = new CategoryAxis();  // Asse X come Categoria (per la divisibilità)
        NumberAxis yAxis = new NumberAxis();  // Asse Y come numerico
        xAxis.setLabel("Divisibilità"); // Etichetta per l'asse X
        yAxis.setLabel("Valore"); // Etichetta per l'asse Y

        // Crea il ScatterChart con gli assi X e Y
        ScatterChart<String, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);

        // Crea una serie di dati per il grafico
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Dati Inseriti");

        // Aggiungi i dati alla serie
        for (int i = 0; i < 10; i++) {
            // Esegui un calcolo di esempio, ad esempio i valori divisi per 3 e 5
            String divisibility = (i % 3 == 0 && i % 5 == 0) ? "by 3 and 5" :
                    (i % 3 == 0) ? "by 3" :
                            (i % 5 == 0) ? "by 5" : "neither";

            // Aggiungi i dati alla serie (per ogni i, vediamo se è divisibile per 3, 5 o entrambi)
            series.getData().add(new XYChart.Data<>(divisibility, i));  // Usa divisibilità come categoria e i come valore
        }

        // Aggiungi la serie al grafico
        scatterChart.getData().add(series);

        // Crea la scena e mostra il grafico
        Scene scene = new Scene(scatterChart, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Esempio di ScatterChart");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
