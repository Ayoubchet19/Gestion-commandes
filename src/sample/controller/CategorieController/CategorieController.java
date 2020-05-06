package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.StringDatatypeValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import sample.model.Categorie;



import java.net.URL;
import java.util.ResourceBundle;

public class CategorieController implements Initializable {
    @FXML
    JFXTextField label;
    @FXML
    JFXButton add;
    @FXML
    void Addcat(ActionEvent event) {

        if(!label.getText().equals("")){ Categorie c = new Categorie();c.setLibele(label.getText());c.insert(c);label.clear();}
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //!VALIDATOR
        RequiredFieldValidator Validator = new RequiredFieldValidator();
        label.getValidators().add(Validator);Validator.setMessage("Champ Libele Obligatoir");
        label.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){ label.validate(); } }});




    }

}