package sample.controller.ClientController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.model.Categorie;
import sample.model.Client;
import sample.model.Produit;

import java.io.IOException;

public class AjouterClientController {

    @FXML
    private JFXTextField num_tel;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton Annuler;

    @FXML
    private JFXButton retour;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXRadioButton sexe;
    @FXML
    private JFXRadioButton sexe1;

    @FXML
    void AddProduct(ActionEvent event) {
            if(num_tel.getText().equals("") || prenom.getText().equals("") || email.getText().equals("") || nom.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setContentText("Veuillez Remplire les champs vides !!");
                alert.showAndWait();}
            else {
                Client c = new Client();
                c.setNum_tel(num_tel.getText());
                c.setNom(nom.getText());
                c.setPrenom(prenom.getText());
                c.setSexe(sexe.getText());
                c.setEmail(email.getText());
                c.insert(c);
            }

    }
        @FXML
        public void  Retour(ActionEvent event) throws IOException {
           add.getScene().getWindow().hide();
        }


    @FXML
    void vider(ActionEvent event) {

    }

}
