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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Command;

import java.io.IOException;
import java.net.URL;
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
    private int id =0;

    @FXML
    private Button searchB;

    @FXML
    private Button newcommande;

    @FXML
    private Button supcom;

    @FXML
    private Button modicomm;

    @FXML
    void modicomm(ActionEvent event) throws IOException {
        Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/AjoutCommand.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        Command c1 = tab_Commandes.getSelectionModel().getSelectedItem();
        this.id=c1.getId();
        window.show();
    }


    @FXML
    void searchB(ActionEvent event) {

        Command C1=new Command();
        if(!search.getText().isEmpty()) {
        tab_Commandes.setItems(C1.search(search.getText()));
        modicomm.setVisible(true);
        supcom.setVisible(true);
        }
        else{ tab_Commandes.setItems(C.ShowAllcommand());
            modicomm.setVisible(false);
            supcom.setVisible(false);
        }
    }

    @FXML
    void supcom(ActionEvent event) {
        //Command c1=new Command();

            Command c1 = tab_Commandes.getSelectionModel().getSelectedItem();
            c1.SupprimerComm(c1.getId());
            tab_Commandes.setItems(C.ShowAllcommand());



        //System.out.println(c1.toString());
    }


    @FXML
    void newcommandes(ActionEvent event) throws IOException {
        Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/AjoutCommand.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        window.show();
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

        modicomm.setVisible(false);
        supcom.setVisible(false);


        try { tab_Commandes.setItems(C.ShowAllcommand());}
         catch (Exception ex){ System.out.println(ex.toString()); }
    }
}


