package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.assests.helper.Dbhandeler;

import java.sql.*;

public class Produit  extends Dbhandeler {
    public int id;
    public String libele;
    public int quantite;
    public Double prix;
    public int id_cat;//for add id category to database
    public String Libele_cat;//for fetching libele category from database
    public String getLibele_cat() { return Libele_cat; } public void setLibele_cat(String Libele_cat) { this.Libele_cat = Libele_cat; }
    public int getId_cat(){return this.id_cat;} public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }
    public Double getPrix() { return prix; }public void setPrix(Double prix) { this.prix = prix; }
    public Produit() { }


    public void insert(Produit p){
        try{
            Connection con=this.Connect();
            PreparedStatement pstm=con.prepareStatement("INSERT INTO produit(Libele,Quantity,CategorieId,Prix)Values(?,?,?,?)");
            pstm.setString(1,p.getLibele());
            pstm.setInt(2,p.getQuantite());
            pstm.setInt(3,p.getId_cat());
            pstm.setDouble(4,p.getPrix());
            pstm.executeUpdate();
            pstm.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void SupprimerProd(int id){
        try{
            Connection con=this.Connect();
            PreparedStatement pstm=con.prepareStatement("delete from produit where ProduitId=?");
            pstm.setInt(1,id);
            pstm.executeUpdate();
            pstm.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage()); }
    }
    public ObservableList<Produit> ShowAllProduct(){
        ObservableList<Produit>Prod= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT ProduitId,Libele,Quantity,LibeleCat,Prix from produit inner join Categorie on Categorie.CatId=produit.CategorieId");
            while(rs.next()){
                Produit P =new Produit();
                P.setId(rs.getInt("ProduitId"));
                P.setLibele(rs.getString("Libele"));
                P.setQuantite(rs.getInt("Quantity"));
                P.setLibele_cat(rs.getString("LibeleCat"));
                P.setPrix(rs.getDouble("Prix"));
                Prod.add(P);
            }
            stm.close();
            con.close();
        }catch (SQLException e){ System.out.println(e.getMessage()); }
        return Prod;
    }

    public int getId() { return id; }public void setId(int id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }public void setLibele(String libele) {
        this.libele = libele;
    }

    public int getQuantite() {
        return quantite;
    }public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return  libele+""; }
}
