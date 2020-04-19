package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.assests.helper.Navloder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasterpageController implements Initializable {

    @FXML
    private BorderPane Parent;



    Navloder navl =new Navloder();


    @Override
    public void initialize(URL URL, ResourceBundle rb){

    }

    @FXML
    void Commande(ActionEvent event) {
        //navl.NavRouter("Commande",Parent);
        navl.NavRouter("test",Parent);
    }

    @FXML
    void Produit(ActionEvent event) {
        navl.NavRouter("Produit",Parent);
    }

    @FXML
    void RecherClient(ActionEvent event) {

        navl.NavRouter("Searchclient",Parent);
    }

    @FXML
    void RechercherCommmande(ActionEvent event) {
        navl.NavRouter("Searchcommande",Parent);
    }

    @FXML
    void Statistique(ActionEvent event) {
        navl.NavRouter("Statistique",Parent);
    }

    @FXML
    void Info(ActionEvent event) {
        navl.NavRouter("Info",Parent);
    }



}
