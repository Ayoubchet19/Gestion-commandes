package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.assests.helper.Dbhandeler;

import java.sql.*;

public class Categorie extends Dbhandeler {

    private int id;
    private String libele;
    public Categorie(){}

    public void insert(Categorie C){this.exequery("INSERT INTO Categorie(LibeleCat) Values(?)",C.getLibele()); }

    public ObservableList<Categorie> showCategorie(){
        ObservableList<Categorie>Categ= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM Categorie");
            while(rs.next()){
                Categorie c =new Categorie();
                c.setId(rs.getInt("CatId"));
                c.setLibele(rs.getString("LibeleCat"));
                Categ.add(c);
            }
            stm.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Categ;
    }

    public ObservableList<Categorie> SelectCate(int idc){
        ObservableList<Categorie>cat1= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            PreparedStatement pstm=con.prepareStatement("select * from Categorie where CatId=?");
            pstm.setInt(1,idc);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                Categorie c1 =new Categorie();
                c1.setId(rs.getInt("CatId"));
                c1.setLibele(rs.getString("LibeleCat"));
                cat1.add(c1);
            }
            pstm.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage()); }
        return cat1;

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibele() {
        return libele;
    }
    public void setLibele(String libele) {
        this.libele = libele;
    }
    @Override
   public String toString() { return  libele; }
}