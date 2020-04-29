package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.assests.helper.Dbhandeler;

import java.sql.*;

public class Client extends Dbhandeler {
    public int id_client;
    public String Num_tel;
    public String nom;
    public String prenom;
    public String sexe;
    public String email;

    public Client() {
    }


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(String num_tel) {
        Num_tel = num_tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", Num_tel='" + Num_tel + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                "email=" + email +
        '}';
    }

    public void insert(Client c) {
        try {
            Connection con = this.Connect();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO client(Num_tel,nom,prenom,sexe,email)Values(?,?,?,?,?)");
            pstm.setString(1, c.getNum_tel());
            pstm.setString(2, c.getNom());
            pstm.setString(3, c.getPrenom());
            pstm.setString(4, c.getSexe());
            pstm.setString(5, c.getEmail());
            pstm.executeUpdate();
            pstm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Client> ShowAllClient(){
        ObservableList<Client>client= FXCollections.observableArrayList();
        try{
            Connection con=this.Connect();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * from client ");
            while(rs.next()){
                Client c =new Client();
                c.setId_client(rs.getInt("id_client"));
                c.setNum_tel(rs.getString("num_tel"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setSexe(rs.getString("sexe"));
                c.setEmail(rs.getString("email"));
                client.add(c);
            }
            stm.close();
            con.close();
        }catch (SQLException e){ System.out.println(e.getMessage()); }
        return client;
    }

}
