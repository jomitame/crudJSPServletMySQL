package com.shipis.cjsm.models;

import com.shipis.cjsm.db.Conexion;

import java.sql.*;

public class LoginUser {

    public boolean isValidUserLogin (String pUserName, String pUserPass){

        boolean isValidUser = false;

        Connection con = Conexion.getConnection();

        PreparedStatement stat = null;
        String sql = "";

        try {


            //creating a query
            sql = "SELECT * FROM usuarios WHERE nombre=? AND contra=?";

            //making a statement
            stat = con.prepareStatement(sql);
            stat.setString(1,pUserName);
            stat.setString(2,pUserPass);

            //Execute a query
            ResultSet rs = stat.executeQuery();

            // Extract data from resulset
            if(rs.next()){
                isValidUser = true;
            }

            // Clean-up enviroment
            rs.close();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(con!=null){con.close();}
            }catch (SQLException se){
                se.printStackTrace();
            }
        }

        return isValidUser;
    }

}
