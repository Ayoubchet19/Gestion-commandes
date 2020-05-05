package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import sample.model.Client;
import sample.model.Command;
import sample.model.Produit;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    Produit P = new Produit();
   if(label.getText().equals("") || Prix.getText().equals("") || quantity.getText().equals("") || Category.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez Remplire les champs vides !!");
            alert.showAndWait();}

    else if(add.getText()!="Update") {
          Produit p = new Produit();
            p.setLibele(label.getText());
            p.setQuantite(Integer.parseInt(quantity.getText()));
            p.setPrix(Double.parseDouble(Prix.getText()));
            Categorie c = Category.getSelectionModel().getSelectedItem();
            p.setId_cat(c.getId());
            p.insert(p);
            vider();
        }
    else {
        P.Upadate(this.li.id,label.getText(),Integer.parseInt(quantity.getText()),Double.parseDouble(Prix.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setHeaderText(null);
        alert.setContentText("Product updated succesfuly ");alert.showAndWait();
    }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    Categorie cat=new Categorie();
    Category.setItems(cat.showCategorie());
    }

    public void  Retour(ActionEvent event) throws IOException {
        retour.getScene().getWindow().hide();
         }
    public Produit li=null;
    public void setUpdate(String re){ add.setText(re.toString()); }
    public void setVisibilite(Boolean b){ Annuler.setVisible(b); }//Cacher le button Annuler l'ors de Modificattion
//* remplir les champs par les valeurs recupereé appartir le produit selectionné
    public void setcommd(Produit c){
        this.li=c;
        Categorie catego= new Categorie();
        Category.setItems(catego.SelectCate(li.id_cat));
        //System.out.println(li.id_cat);
        Category.getSelectionModel().select(0);//par defaut selectionner la ctaégorie trouveé
        Category.setDisable(true);
        quantity.setText(li.getQuantite()+"");
        Prix.setText(li.getPrix()+"");
        label.setText(li.getLibele());


    }
}

