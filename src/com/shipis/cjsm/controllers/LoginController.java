package com.shipis.cjsm.controllers;

import com.shipis.cjsm.models.LoginUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //instanciamos un objeto de la clase LoginUser para poder validar los datos
        LoginUser myLoginUser = new LoginUser();
        //validacion de datos
        if(myLoginUser.isValidUserLogin(request.getParameter("fUsuario"), request.getParameter("fContra"))){
            //de ser correctos los datos redirigimos a la pagina principal de paso se van los atributos
            request.setAttribute("usuario", request.getParameter("fUsuario"));
            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
        }else{
            //si no son correctos los datos enviamos mensaje de error a la misma página del login
            request.setAttribute("errorMessage", "Datos Errados");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
