package sample.controller.CommandeController;

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.assests.helper.Helper;
import sample.model.Command;
import sample.model.Produit;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {
    private Command C=new Command();
    @FXML
    private TableView<Command> tab_Commandes;

    @FXML
    private TableColumn<Command, Integer> id_commande;

    @FXML
    private TableColumn<Command, String> client_col;

    @FXML
    private TableColumn<Command, String> produit_col;

    @FXML
    private TableColumn<Command, Double> prix_col;

    @FXML
    private TableColumn<Command, String> adress_col;

    @FXML
    private TableColumn<Command, Integer> quantite_col;

    @FXML
    private TableColumn<Command, Double> total_col;

    @FXML
    private TableColumn<Command, String> status_col;
    @FXML
    private TableColumn<Command, String> Date_col;
    @FXML
    private JFXTextField search;
    @FXML
    void modicomm(ActionEvent event) throws IOException {
        if(tab_Commandes.getSelectionModel().isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner la Commande a Modifier !!");
            alert1.showAndWait();
        }
        else{
            FXMLLoader loder=new FXMLLoader();
            Stage master=new Stage();
            loder.setLocation(getClass().getResource(  "../../views/CommandeView/AjoutCommand.fxml"));
            loder.load();
            Parent root =loder.getRoot();
            Scene secene=new Scene(root, 800, 550);
            master.setTitle("Modifier Commande");
            AjouterCommandeController m=loder.getController();
            Command c1 = tab_Commandes.getSelectionModel().getSelectedItem();
            c1=c1.searchob(c1.getId()+"");
            m.setUpdate("Update");
            m.setcommd(c1);
            m.SetVisibilite(false);
            master.centerOnScreen();
            master.show();
            master.setScene(secene);
        }

    }

    @FXML
    void Refresh(ActionEvent event){ tab_Commandes.setItems(C.ShowAllcommand()); }

    @FXML
    void searchB(ActionEvent event) { Command C1=new Command();
        if(!search.getText().isEmpty()) {
        tab_Commandes.setItems(C1.search(search.getText()));
        }
        else {Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
        alert1.setContentText("Veuillez Selectionner la Commande a Rechercher !!");
        alert1.showAndWait();
            tab_Commandes.setItems(C.ShowAllcommand()); }
    }

    @FXML
    void supcom(ActionEvent event) {
        if(tab_Commandes.getSelectionModel().isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner la Commande a supprimer !!");
            alert1.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vous voullez Supprimer cette Commande ??");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Command c1 = tab_Commandes.getSelectionModel().getSelectedItem();
                c1.SupprimerComm(c1.getId());
                tab_Commandes.setItems(C.ShowAllcommand());
            }
        }
    }


    @FXML
    void newcommandes(ActionEvent event) throws IOException {
        Stage master=new Stage();
        FXMLLoader loder=new FXMLLoader();
        loder.setLocation(getClass().getResource("../../views/CommandeView/AjoutCommand.fxml"));
        loder.load();
        Parent root =loder.getRoot();
        Scene secene=new Scene(root, 800, 550);
        master.setTitle("Gestion Des Commandes");
        master.setScene(secene);
        master.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id_commande.setCellValueFactory(new PropertyValueFactory<>("id"));
        client_col.setCellValueFactory(new PropertyValueFactory<>("client"));
        produit_col.setCellValueFactory(new PropertyValueFactory<>("produit"));
        prix_col.setCellValueFactory(new PropertyValueFactory<>("prix"));
        adress_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        quantite_col.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        Date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        try { tab_Commandes.setItems(C.ShowAllcommand());}
         catch (Exception ex){ System.out.println(ex.toString()); }
    }
}


