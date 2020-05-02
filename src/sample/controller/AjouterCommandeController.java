package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.assests.helper.Helper;
import sample.model.Categorie;
import sample.model.Client;
import sample.model.Command;
import sample.model.Produit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjouterCommandeController implements Initializable {
    @FXML
    private JFXComboBox<Produit> allproduit;

    @FXML
    private JFXTextField quantity;

    @FXML
    private JFXComboBox<Client> allClient;

    @FXML
    private JFXComboBox<String> status;

    @FXML
    private JFXDatePicker datech;

    @FXML
    private JFXTextField adresse;

    @FXML
    void AddCommand(ActionEvent event) {

            Command C = new Command();
            Produit p =allproduit.getSelectionModel().getSelectedItem();
            Client c =allClient.getSelectionModel().getSelectedItem();
       // System.out.println(p.getId( )+" " +c.getId_client());
            C.setId_client(c.getId_client());
            C.setId_prod(p.getId( ));
            C.setQuantite(Integer.parseInt(quantity.getText()));
            C.setDate(datech.getValue().toString());
            C.setAdresse(adresse.getText());
            C.setStatus(status.getValue());
            C.insert(C);
            //vider();



    }

    @FXML
    void Retour(ActionEvent event) throws IOException {
        Helper navl =new Helper();
        ///navl.NavRouter("Commande",Parent);
        Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/Commande.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        window.show();
    }

    @FXML
    void vider(ActionEvent event) {
        allproduit.getSelectionModel().clearSelection();quantity.clear();adresse.clear();allClient.getSelectionModel().clearSelection();status.getSelectionModel().clearSelection();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Produit P=new Produit();
        Client C=new Client();
       // allClient.valueProperty().bindBidirectional(C.ShowAllClient().get().prenom);
        allClient.setItems(C.ShowAllClient());
        allproduit.setItems(P.ShowAllProduct());
        status.getItems().addAll("Livre",
                "En cours","Annule");
    }
}
