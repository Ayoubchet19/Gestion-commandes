package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import sample.model.Categorie;



import java.net.URL;
import java.util.ResourceBundle;

public class CategorieController implements Initializable {
    @FXML
    JFXTextField label;
    @FXML
    JFXButton add;
    @FXML
    void Addcat(ActionEvent event) {
        if(label.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez Remplire le champ Libele !!");
            alert.showAndWait();}
        else {  Categorie c = new Categorie();c.setLibele(label.getText());c.insert(c);label.clear();}
       }
    @Override
    public void initialize(URL location, ResourceBundle resources) { }

}