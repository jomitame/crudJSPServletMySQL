package com.shipis.cjsm.models;

import com.shipis.cjsm.db.Conexion;

import java.sql.*;

public class LoginUser {

    public boolean isValidUserLogin (String pUserName, String pUserPass){

        boolean isValidUser = false;

        Connection con = Conexion.getConnection();

        Statement stat = null;
        String sql = "";

        try {
            //making a statement
            stat = con.createStatement();
            //creating a query
            sql = "SELECT * FROM usuarios WHERE nombre = \"" +
                    pUserName + "\" AND contra = \"" + pUserPass + "\"";

            //Execute a query
            ResultSet rs = stat.executeQuery(sql);

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
