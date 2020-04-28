package sample.controller;


import com.jfoenix.controls.JFXComboBox;
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
import javafx.util.Callback;
import sample.model.Categorie;
import sample.model.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {

    Produit prod = new Produit();
    @FXML private TableView<Produit> Display;

    @FXML private JFXComboBox<Produit> idprod;
    @FXML private TableColumn<Produit, Integer> ID_Produit;
    @FXML private TableColumn<Produit, String> Libele;
    @FXML private TableColumn<Produit, Integer> Quantite;
    @FXML private TableColumn<Produit, String> Categories;
    @FXML private TableColumn<Produit, Double> Prix;

    public  void DeleteProduct(ActionEvent event){
        if(idprod.getSelectionModel().isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setContentText("Veuillez Selectionner l'Id produit !!");
            alert1.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vous voullez Supprimer ce produit ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
               Produit pp = idprod.getSelectionModel().getSelectedItem();
                prod.SupprimerProd(pp.id);
                Display.setItems(prod.ShowAllProduct());
                idprod.setItems(prod.ShowAllProduct());
            }
        }
}
//AddProd permet de changer la scene actuelle vers la scene d'ajout des produits
    public void  AddProd(ActionEvent event) throws IOException {
        Parent ProductParent= FXMLLoader.load(getClass().getResource("../views/AjoutProduit.fxml"));
        Scene ProductScene=new Scene(ProductParent);
        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ProductScene);
        window.show();
    }
//!!lorsque la scene produit charge ,automatiquement(par defaut)toutes  les donnes  produit sera afficher
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idprod.setItems(prod.ShowAllProduct());
        ID_Produit.setCellValueFactory(new PropertyValueFactory<>("id"));
        Libele.setCellValueFactory(new PropertyValueFactory<>("libele"));
        Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        Categories.setCellValueFactory(new PropertyValueFactory<>("Libele_cat"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
      try { Display.setItems(prod.ShowAllProduct()); }
      catch (Exception ex){ System.out.println(ex.toString()); }

    }


}