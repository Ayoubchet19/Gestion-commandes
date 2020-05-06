package sample.controller.UtulisateurController;


import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.assests.helper.Helper;
import sample.model.Produit;
import sample.model.Utulisateur;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AfficherUtulisateurController implements Initializable {
    public Utulisateur U = new Utulisateur();
    @FXML
    private TableView<Utulisateur> Display;
    @FXML
    private TableColumn<Utulisateur, Integer> ID_user;
    @FXML
    private TableColumn<Utulisateur, String> Username;
    @FXML
    private TableColumn<Utulisateur, String> Email;
    @FXML private JFXTextField searchFX;

    @FXML
    void Refresh(ActionEvent event){ Display.setItems(U.ShowAllUsers()); }
    @FXML
    void Add(ActionEvent event) throws IOException {
        Stage master=new Stage();
        FXMLLoader loder=new FXMLLoader();
        loder.setLocation(getClass().getResource("../../views/UtulisateurView/AjoutUtulisateur.fxml"));
        loder.load();
        Parent root =loder.getRoot();
        Scene secene=new Scene(root, 800, 550);
        master.setTitle("Gestion Des Commandes");
        master.setScene(secene);
        master.show();
    }
    @FXML
    void DeleteUser(ActionEvent event) {
        if(Display.getSelectionModel().isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner l'utulisateur a supprimer !!");
            alert1.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vous voullez Supprimer ce Utulisateur ??");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Utulisateur U = Display.getSelectionModel().getSelectedItem();
                U.Delete(U.getIduser());
                Display.setItems(U.ShowAllUsers()); }}}
    @FXML
    void Search(ActionEvent event) {

        Utulisateur US=new Utulisateur();
        if(!searchFX.getText().isEmpty()) {
            Display.setItems(US.SearchMulti(searchFX.getText()));
        }
        else{ Display.setItems(US.ShowAllUsers());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setHeaderText(null);
            alert.setContentText("Vueliiez saisir l'utulisateur a rechercher !! ");alert.showAndWait();
        }}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID_user.setCellValueFactory(new PropertyValueFactory<>("iduser"));
        Username.setCellValueFactory(new PropertyValueFactory<>("username"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        try { Display.setItems(U.ShowAllUsers()); }
        catch (Exception ex){ System.out.println(ex.toString()); }

    }
}




