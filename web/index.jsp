<%--
  Created by IntelliJ IDEA.
  User: ACER1
  Date: 15/12/2018
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-third w3-display-topmiddle">
    <div class="w3-container w3-blue">
        <h2>Ingreso</h2>
    </div>

    <form action="LoginController" class="w3-container" method="post">
        <p>
            <label for="usuario">Usuario</label>
            <input class="w3-input" type="text" name="fUsuario" id="usuario"></p>
        <p>
            <label for="contra">Contraseña</label>
            <input class="w3-input" type="password" name="fContra" id="contra"></p>
        <p>
            <input type="submit" value="Ingresar" class="w3-button w3-white w3-border w3-border-blue w3-round-large">
            <button class="w3-button w3-white w3-border w3-border-blue w3-round-large">Registrarse</button>
        </p>
    </form>
    <div class="w3-panel w3-red">${errorMessage}</div>
</div>

<div class="w3-threequarter w3-display-bottommiddle">
    <table></table>
</div>

</body>
</html>
