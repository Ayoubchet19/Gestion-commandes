package sample.controller;

import com.jfoenix.controls.JFXPasswordField;
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
import javafx.stage.Stage;
import sample.model.Produit;
import sample.model.Utulisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AjouterUtulisateur implements Initializable {
    @FXML private JFXTextField username;
    @FXML private JFXPasswordField pass;
    @FXML private JFXPasswordField ConfirmPass;
    @FXML private JFXTextField email;
    @FXML
    public void vider(){username.clear();email.clear();pass.clear();ConfirmPass.clear();}
    @FXML
    void AddUSer(ActionEvent event) {
        if(username.getText().equals("") || email.getText().equals("")||
                pass.getText().equals("")||ConfirmPass.getText().equals("") ){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);alert1.setContentText("Remplire les champ(s) Vide(s) !!");
            alert1.showAndWait();
        }
       else if(!pass.getText().equals(ConfirmPass.getText())){Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);alert1.setContentText("Password and Confirm password doesn't match !!");
            alert1.showAndWait();}
        else {  Utulisateur u = new Utulisateur();
            u.setUsername(username.getText());
            u.setEmail(email.getText());
            u.setPass(pass.getText());
            u.insert(u);vider(); }
    }

    @FXML
    void Retour(ActionEvent event) throws IOException {
        Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/Masterpage.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
