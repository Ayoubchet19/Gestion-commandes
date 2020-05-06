package sample.controller.ClientController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherClientController implements Initializable {

    @FXML
    private TableView<Client> Display;

    @FXML
    private TableColumn<Client, Integer> ID_Client;

    @FXML
    private TableColumn<Client, String> Telephone;

    @FXML
    private TableColumn<Client, String> Nom;

    @FXML
    private TableColumn<Client, String> Prenom;

    @FXML
    private TableColumn<Client, String> Sexe;
    @FXML
    private TableColumn<Client, String> Email;
    public Client c=new Client();

    @FXML
    private JFXTextField searchFX;

    @FXML
    private JFXButton rechrche;

    @FXML
    void rechercher(ActionEvent event) {
        Client c = new Client();
        Display.setItems(c.rechercherClient(searchFX.getText()));
        System.out.println("test");

    }

    @FXML
    void search(ActionEvent event) {



    }


    @FXML
    public void  AddClient(ActionEvent event) throws IOException {
        Stage master=new Stage();
        FXMLLoader loder=new FXMLLoader();
        loder.setLocation(getClass().getResource(  "../../views/ClientView/AjouterClient.fxml"));
        loder.load();
        Parent root =loder.getRoot();
        Scene secene=new Scene(root, 800, 550);
        master.setTitle("Gestion Des Commandes");
        master.setScene(secene);
        master.show();
        System.out.println("hhh");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ID_Client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        Telephone.setCellValueFactory(new PropertyValueFactory<>("Num_tel"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        try { Display.setItems(c.ShowAllClient()); }
        catch (Exception ex){ System.out.println(ex.toString()); }

    }
}
