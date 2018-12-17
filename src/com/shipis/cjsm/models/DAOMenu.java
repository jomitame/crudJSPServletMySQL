package com.shipis.cjsm.models;

import com.shipis.cjsm.db.Conexion;
import com.shipis.cjsm.entities.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMenu {

    private Connection con = null;
    private PreparedStatement myPrepStat = null;
    private ResultSet myRS = null;
    private String sql = "";

    public List<Menu> loadMenu1(int pRolUser){
        con = Conexion.getConnection();
        List<Menu> myListMenu = new ArrayList<Menu>();

        try{
            sql = "SELECT menus.idmenu, menus.titulomenu, menus.enlacemenu FROM menus INNER JOIN privilegios ON privilegios.codmenu = menus.idmenu WHERE menupadre = 0 AND privilegios.codrol =?";
            myPrepStat = con.prepareStatement(sql);
            myPrepStat.setInt(1,pRolUser);
            myRS = myPrepStat.executeQuery();
            while(myRS.next()){
                Menu myMenu = new Menu();
                myMenu.setId(myRS.getInt("idmenu"));
                myMenu.setTitulo(myRS.getString("titulomenu"));
                myMenu.setEnlace(myRS.getString("enlacemenu"));
                //myMenu.setPadre(myRS.getInt("menupadre"));
                //myMenu.setEstado(myRS.getInt("estado"));

                myListMenu.add(myMenu);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return myListMenu;
    }

    public List<Menu> loadMenu2(int pRolUser, int pPadre){
        con = Conexion.getConnection();
        List<Menu> myListMenu = new ArrayList<Menu>();

        try{
            sql = "SELECT menus.idmenu, menus.titulomenu, menus.enlacemenu FROM menus INNER JOIN privilegios ON privilegios.codmenu = menus.idmenu WHERE menupadre =? AND privilegios.codrol =?";
            myPrepStat = con.prepareStatement(sql);
            myPrepStat.setInt(1,pPadre);
            myPrepStat.setInt(2,pRolUser);
            myRS = myPrepStat.executeQuery();
            while(myRS.next()){
                Menu myMenu = new Menu();
                myMenu.setId(myRS.getInt("idmenu"));
                myMenu.setTitulo(myRS.getString("titulomenu"));
                myMenu.setEnlace(myRS.getString("enlacemenu"));

                myListMenu.add(myMenu);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return myListMenu;
    }
}
