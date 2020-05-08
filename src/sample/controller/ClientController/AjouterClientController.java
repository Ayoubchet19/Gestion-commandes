package sample.controller.ClientController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AjouterClientController implements Initializable {

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
    public void Vider(){num_tel.clear();nom.clear();prenom.clear();email.clear();homme.setSelected(false);femme.setSelected(false);
       prenom.resetValidation();
        email.resetValidation();
        nom.resetValidation();

    }
    @FXML
    void AddClient(ActionEvent event) {
        Client c = new Client();
        boolean valide=true;
        if(!(num_tel.validate() && prenom.validate() && email.validate() && nom.validate())){valide=false;
            num_tel.validate(); prenom.validate(); email.validate(); nom.validate();
//            int t=0;
//            try {
//                Integer.parseInt(num_tel.getText());
//            }catch (NumberFormatException e){
//                t=-1;
//            }
//            if(t==-1) {
//                valide = false;
////                prenom.resetValidation();
////               email.resetValidation();
////                nom.resetValidation();
//                num_tel.activeValidatorProperty();
//            }
//            else {
//                valide = true;
////                num_tel.resetValidation();
////                prenom.resetValidation();
////                email.resetValidation();
////                nom.resetValidation();
//            }
          if(!email.getText().matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)")){
//              //  prenom.resetValidation();
                email.validate();
//              //  nom.resetValidation();
//               // num_tel.resetValidation();
       valide = false;
            }else {
             valide = true;
          }
////            num_tel.resetValidation();
////            prenom.resetValidation();
////            email.resetValidation();
////            nom.resetValidation();

        }
       else {num_tel.validate(); prenom.validate(); email.validate(); nom.validate(); valide=true;}
           if(add.getText()!="Update"&& valide) {
                c.setNum_tel(num_tel.getText());
                c.setNom(nom.getText());
                c.setPrenom(prenom.getText());
                if(this.sexe.getSelectedToggle().equals(this.homme)){LibeleSexe="Homme";}
                if(this.sexe.getSelectedToggle().equals(this.femme)){LibeleSexe="Femme";}
                c.setSexe(LibeleSexe);
                c.setEmail(email.getText());
                c.insert(c);Vider();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setHeaderText(null);
               alert.setContentText("Client Ajouter succesfuly ");alert.showAndWait();
//                Annuler.setVisible(true);
            }
            else if(add.getText()=="Update"&& valide) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        homme.setSelected(true);
    }
}
