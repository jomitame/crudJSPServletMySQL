package com.shipis.cjsm.db;

import com.shipis.cjsm.settings.Data;

import java.sql.*;

public class Conexion {

    public static Connection getConnection(){

        Connection conn = null;

        try{
            //Register JDBC driver
            Class.forName(Data.JDBC_DRIVER);
            //Open a connection
            conn = DriverManager.getConnection(Data.DB_URL, Data.USER, Data.PASS);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return conn;
    }
}
