package sample.controller.CategorieController;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import sample.assests.helper.Helper;
import sample.model.Categorie;



import java.net.URL;
import java.util.ResourceBundle;

public class CategorieController implements Initializable {
    Categorie cat = new Categorie();
    @FXML
    JFXTextField label;
    @FXML
    JFXButton add;
    @FXML
    private TableView<Categorie> data;
    @FXML
    private Button refre;

    @FXML
    private TableColumn<Categorie, Integer> id;

    @FXML
    private TableColumn<Categorie, String> lib;

    @FXML
    private JFXTextField rechrtex;

    @FXML
    private Button SearchButton;
    Helper h=new Helper();
    @FXML
    void Addcat(ActionEvent event) {

        if(!label.getText().equals("")){ Categorie c = new Categorie();c.setLibele(label.getText());c.insert(c);label.clear();
            label.resetValidation();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Categorie Added Succefuly");
            alert1.showAndWait();
        }
        else
            label.validate();
}

    @FXML
    void Refresh(ActionEvent event) {
     data.setItems(cat.showCategorie());
    }

    @FXML
    void Search(ActionEvent event) {
        rechrtex.resetValidation();
        if(rechrtex.getText().isEmpty()){
             rechrtex.validate();
        }else {

       if(!cat.SelectCatemul(rechrtex.getText()).isEmpty()){
           data.setItems(cat.SelectCatemul(rechrtex.getText()));
       }else {
           Helper.Alert("Élément n'existe pas");
       }
       rechrtex.clear();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lib.setCellValueFactory(new PropertyValueFactory<>("libele"));
        refre.fire();

    }

}