package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.assests.helper.Dbhandeler;

import java.sql.*;

public class Categorie extends Dbhandeler {

    private int id;
    private String libele;
    public Categorie(){}

    public void insert(Categorie C){
        try{
            Connection con=this.Connect();
            PreparedStatement pstm=con.prepareStatement("INSERT INTO Categorie(LibeleCat) Values(?)");
            pstm.setString(1,C.getLibele());
            pstm.execute();
            pstm.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

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
