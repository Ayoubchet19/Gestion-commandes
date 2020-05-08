package sample.controller.StatistiqueController;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import sample.model.Produit;

import java.net.URL;
import java.util.ResourceBundle;


public class StatistiqueController  implements Initializable {
    @FXML
    private PieChart Satas;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Produit p =new Produit();
        p.chrats();
//        ObservableList<PieChart.Data> piDat= FXCollections.observableArrayList(
//                new PieChart.Data("It pro",40),
//                new PieChart.Data("Nursing",10),
//                new PieChart.Data("Medcine",5)
//        );
//        Satas.setData(piDat);
        Satas.setData(p.chrats());
        Satas.setStartAngle(90);


    }
}
