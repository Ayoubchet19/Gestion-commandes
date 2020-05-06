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

//!l'utulisation de la methode exequery()
    public void insert(Produit p){ this.exequery("INSERT INTO produit(Libele,Quantity,CategorieId,Prix)Values(?,?,?,?)",p.getLibele(),p.getQuantite(),p.getId_cat(),p.getPrix()); }
    public void SupprimerProd(int id){this.exequery("delete from produit where ProduitId=?",id); }
    public void UPdate(int id, String lib, int qnt, Double Prix){this.exequery("update produit set Libele= ?,Quantity=?,Prix=? where ProduitId=?",lib,qnt,Prix,id); }
    public ObservableList<Produit> ShowAllProduct(){
        ObservableList<Produit>Prod= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT ProduitId,CategorieId,Libele,Quantity,LibeleCat,Prix from produit inner join Categorie on produit.CategorieId=Categorie.CatId");
            while(rs.next()){
                Produit P =new Produit();
                P.setId(rs.getInt("ProduitId"));
                P.setLibele(rs.getString("Libele"));
                P.setQuantite(rs.getInt("Quantity"));
                P.setLibele_cat(rs.getString("LibeleCat"));
                P.setId_cat(rs.getInt("CategorieId"));
                P.setPrix(rs.getDouble("Prix"));

                Prod.add(P);
            }
            stm.close();
            con.close();
        }catch (SQLException e){ System.out.println(e.getMessage()); }
        return Prod;
    }

    public Produit searchob(int id){
        Produit P =new Produit();
        try{
            Connection con=this.Connect();
            Statement stm=con.createStatement();
            PreparedStatement pstm=con.prepareStatement("SELECT ProduitId,CategorieId,Libele,Quantity,LibeleCat,Prix from produit inner join Categorie on Categorie.CatId=produit.CategorieId where ProduitId=?  ");
            pstm.setInt(1, id);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                P.setId(rs.getInt("ProduitId"));
                P.setLibele(rs.getString("Libele"));
                P.setQuantite(rs.getInt("Quantity"));
                P.setLibele_cat(rs.getString("LibeleCat"));
                P.setId_cat(rs.getInt("CategorieId"));
                P.setPrix(rs.getDouble("Prix"));

            }
            stm.close();
            con.close();
        }catch (Exception e){ System.out.println(e.toString()); }

        return P;
    }
    public ObservableList<Produit> Selectproduit(int id){
        ObservableList<Produit>Prod= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            PreparedStatement pstm=con.prepareStatement("select * from produit where ProduitId=?");
            pstm.setInt(1,id);
           ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                Produit P =new Produit();
                P.setId(rs.getInt("ProduitId"));
                P.setLibele(rs.getString("Libele"));
                P.setQuantite(rs.getInt("Quantity"));
                P.setId_cat(rs.getInt("CategorieId"));
                P.setPrix(rs.getDouble("Prix"));
                Prod.add(P);
            }
            pstm.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage()); }
        return Prod;
    }

    public ObservableList<Produit> SearchMulti(String S){
        ObservableList<Produit>prod= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            Statement stm=con.createStatement();
            PreparedStatement pstm=con.prepareStatement("SELECT ProduitId,CategorieId,Libele,Quantity,LibeleCat,Prix from produit inner join Categorie on Categorie.CatId=produit.CategorieId where ProduitId=? or Libele=? or Quantity=? or LibeleCat=? or Prix=? ");
            int id;
            try {
                id=Integer.parseInt(S);

            }catch (NumberFormatException e){
                id=0;
            }
            pstm.setInt(1, id);
            pstm.setString(2, S);
            pstm.setString(3, S);
            pstm.setString(4, S);
            pstm.setString(5, S);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Produit P =new Produit();
                P.setId(rs.getInt("ProduitId"));
                P.setLibele(rs.getString("Libele"));
                P.setQuantite(rs.getInt("Quantity"));
                P.setLibele_cat(rs.getString("LibeleCat"));
                P.setId_cat(rs.getInt("CategorieId"));
                P.setPrix(rs.getDouble("Prix"));
                prod.add(P);
            }
            stm.close();
            con.close();
        }catch (Exception e){ System.out.println(e.toString()); }

        return prod;
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
