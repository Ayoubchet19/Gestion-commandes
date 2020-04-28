package sample.assests.helper;

import java.sql.*;

public class Dbhandeler {

    public Connection Connect(){
        Connection con=null;
        try{
           // String urlcon = "jdbc:sqlite::resource:sample/assests/database/DataBasee.db";
            String urlcon = "jdbc:sqlite:DataBasee.db";
            con= DriverManager.getConnection(urlcon);
        }catch (SQLException e){
            Helper.Exseptiongmsg(e.toString());
        }
        return con;
    }

    public ResultSet ExsecuteQ(PreparedStatement pstm){
        ResultSet res= null;
        int count=0;
        try {
            res = pstm.executeQuery();
            res.next();
            count=res.getInt("count(*)");
        } catch (SQLException e) {
            Helper.Exseptiongmsg(e.toString());
        }
        return  res;
    }

    public int Count(PreparedStatement pstm){
        ResultSet res= null;
        int count=0;
        try {
            res = pstm.executeQuery();
            res.next();
            count=res.getInt("count(*)");
            pstm.close();
        } catch (SQLException e) {
            Helper.Exseptiongmsg(e.toString());
        }
        return count;
    }

}
