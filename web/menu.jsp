<%@ page import="com.shipis.cjsm.models.DAOMenu" %>
<%@ page import="com.shipis.cjsm.entities.Menu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: ACER1
  Date: 16/12/2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<%

%>
<div class="w3-bar w3-light-blue">

    <%
        DAOMenu myDAOMenu = new DAOMenu();
        List<Menu> myList = myDAOMenu.loadMenu1((Integer)request.getAttribute("rol"));
        Iterator<Menu> myIterator = myList.iterator();

        while(myIterator.hasNext()){
            Menu myMenu;
            myMenu = myIterator.next();
    %>
        <div class="w3-dropdown-hover">
            <a href="<%= myMenu.getEnlace()%>" class="w3-button"><%= myMenu.getTitulo()%></a>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <%
                    DAOMenu myDAOMenu2 = new DAOMenu();
                    List<Menu> myList2 = myDAOMenu2.loadMenu2((Integer)request.getAttribute("rol"),myMenu.getId());
                    Iterator<Menu> myIterator2 = myList2.iterator();
                    while(myIterator2.hasNext()){
                        Menu myMenu2;
                        myMenu2 = myIterator2.next();
                %>
                        <a href="<%= myMenu2.getEnlace()%>" class="w3-bar-item w3-button"><%= myMenu2.getTitulo()%></a>
                <%
                    }
                %>
            </div>
        </div>

    <%
        }
    %>

    <div class="w3-dropdown-hover w3-right">
        <button class="w3-button">Usuario: ${usuario}</button>
        <div class="w3-dropdown-content w3-bar-block w3-card-4">
            <a href="#" class="w3-bar-item w3-button">Settings</a>
            <a href="#" class="w3-bar-item w3-button">Logout</a>
        </div>
    </div>
    <a href="#" class="w3-bar-item w3-button"></a>
</div>

</body>
</html>
