package com.shipis.cjsm.models;

import com.shipis.cjsm.db.Conexion;

import java.sql.*;

public class LoginUser {

    private ResultSet rs = null;
    private Connection con = null;
    private PreparedStatement stat = null;
    private String sql = "";

    private ResultSet getResulset(String pUserName, String pUserPass){
        con = Conexion.getConnection();
        try{
            //creating a query
            sql = "SELECT * FROM usuarios WHERE nombre=? AND contra=?";

            //making a statement
            stat = con.prepareStatement(sql);
            stat.setString(1,pUserName);
            stat.setString(2,pUserPass);

            //Execute a query
            rs = stat.executeQuery();



        }catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public boolean isValidUserLogin (String pUserName, String pUserPass){
        boolean isValidUser = false;
        rs = this.getResulset(pUserName,pUserPass);
        try {
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

    public int getRol(String pUserName, String pUserPass){
        int id=0;
        rs = this.getResulset(pUserName,pUserPass);
        try{
            if(rs.next()){
                id = rs.getInt("rol");
            }
            rs.close();
            stat.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(con!=null){con.close();}
            }catch (SQLException se){
                se.printStackTrace();
            }
        }

        return id;
    }

}
