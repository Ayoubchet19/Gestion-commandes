package sample.model;

import sample.assests.helper.Dbhandeler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utulisateur extends Dbhandeler {
    public int verfierLogin(String name,String pass){
        int rep=0;
        try {
            Connection con=this.Connect();
            PreparedStatement pstm=con.prepareStatement("Select count(*) from User where (Username=? or email=?)");
            pstm.setString(1,name);
            pstm.setString(2,name);
           if(this.Count(pstm)==1){
               pstm=con.prepareStatement("Select count(*) from User where (Username=? or email=?) and pass=?");
               pstm.setString(1,name);
               pstm.setString(2,name);
               pstm.setString(3,pass);
              if(this.Count(pstm)==1){
                  rep=2;
              }else
                  rep=1;
           }else {
               rep=-1;
           }
            pstm.close();
            con.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return rep;
    }
}
