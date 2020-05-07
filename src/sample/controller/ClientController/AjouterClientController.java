package sample.controller.ClientController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.model.Categorie;
import sample.model.Client;
import sample.model.Command;
import sample.model.Produit;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AjouterClientController {

    @FXML
    private JFXTextField num_tel;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton Annuler;

    @FXML
    private JFXButton retour;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXRadioButton homme;

    @FXML
    private ToggleGroup sexe;

    @FXML
    private JFXRadioButton femme;
    private  String LibeleSexe;

    @FXML
    public void Vider(){num_tel.clear();nom.clear();prenom.clear();email.clear();homme.setSelected(false);femme.setSelected(false);}
    @FXML
    void AddClient(ActionEvent event) {
        Client c = new Client();
            if(!(homme.isSelected()||femme.isSelected())||num_tel.getText().equals("") || prenom.getText().equals("") || email.getText().equals("") || nom.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setContentText("Veuillez Remplire les champs vides !!");
                alert.showAndWait();}
            else if(add.getText()!="Update") {

                c.setNum_tel(num_tel.getText());
                c.setNom(nom.getText());
                c.setPrenom(prenom.getText());
                if(this.sexe.getSelectedToggle().equals(this.homme)){LibeleSexe="Homme";}
                if(this.sexe.getSelectedToggle().equals(this.femme)){LibeleSexe="Femme";}
                c.setSexe(LibeleSexe);
                c.setEmail(email.getText());
                c.insert(c);Vider();
                Annuler.setVisible(true);
            }
            else {
                if(this.sexe.getSelectedToggle().equals(this.homme)){LibeleSexe="Homme";}
                if(this.sexe.getSelectedToggle().equals(this.femme)){LibeleSexe="Femme";}
                c.Upadate(this.li.id_client,num_tel.getText(),nom.getText(),prenom.getText(),LibeleSexe,email.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setHeaderText(null);
                alert.setContentText("Client updated succesfuly ");alert.showAndWait();
            }

    }

    public void setVisibilite(Boolean b){ Annuler.setVisible(b); }//Cacher le button Annuler l'ors de Modificattion

    @FXML
        public void  Retour(ActionEvent event) throws IOException {
           add.getScene().getWindow().hide();
        }
    public Client li=null;
    public void setclient(Client c1){
        this.li=c1;
        nom.setText(li.getNom());
        num_tel.setText(li.getNum_tel());
        prenom.setText(li.getPrenom());
        email.setText(li.getEmail());
        if (li.getSexe().equals("Homme")){
           homme.setSelected(true);
        }
        else{femme.setSelected(true);}







    }
    public void setUpdate(String re){
        add.setText(re.toString());
    }



    @FXML
    void vider(ActionEvent event) {

    }

}
