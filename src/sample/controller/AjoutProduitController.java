package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.model.Categorie;
import sample.model.Produit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjoutProduitController implements Initializable {


    @FXML
    JFXTextField label;
    @FXML
    JFXTextField Prix;
    @FXML
    JFXTextField quantity;
    @FXML
    JFXButton Annuler;
    @FXML
    JFXButton retour;
    @FXML
    JFXButton add;
    @FXML
    JFXComboBox<Categorie> Category;
@FXML
public void vider(){label.clear();quantity.clear();Prix.clear();Category.getSelectionModel().clearSelection();}
    @FXML
    void AddProduct(ActionEvent event) {

    if(label.getText().equals("") || Prix.getText().equals("") || quantity.getText().equals("") || Category.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez Remplire les champs vides !!");
            alert.showAndWait();}
    else {
            Produit p = new Produit();
            p.setLibele(label.getText());
            p.setQuantite(Integer.parseInt(quantity.getText()));
            p.setPrix(Double.parseDouble(Prix.getText()));
            Categorie c = Category.getSelectionModel().getSelectedItem();
            p.setId_cat(c.getId());
            p.insert(p);
            vider();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) { Categorie cat=new Categorie();Category.setItems(cat.showCategorie()); }

    public void  Retour(ActionEvent event) throws IOException {
        Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/MasterPage.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        window.show(); }
}

