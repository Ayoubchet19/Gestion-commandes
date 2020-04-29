package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.assests.helper.Helper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MasterpageController implements Initializable {

    @FXML
    private Text bon;
    @FXML
    private Label usern;
    public void setname(String name){
        bon.setText("Bonjour  "+name);
    }

    @FXML
    private BorderPane Parent;
    Helper navl =new Helper();

    @Override
    public void initialize(URL URL, ResourceBundle rb){ }
    @FXML
    void Commande(ActionEvent event) {
        navl.NavRouter("Commande",Parent);
    }
    @FXML
    void Produit(ActionEvent event) {
        navl.NavRouter("Produit",Parent);
    }
    @FXML
    void categorie(ActionEvent event) {
        navl.NavRouter("Categorie",Parent);
    }

    @FXML
    void RecherClient(ActionEvent event) { navl.NavRouter("AfficherClient",Parent); }

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

    public void  Logout(ActionEvent event) throws IOException {
        javafx.scene.Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/login.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        window.show(); }



}
