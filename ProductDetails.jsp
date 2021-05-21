<%--
  Created by IntelliJ IDEA.
  User: aliyahfaith
  Date: 5/11/21
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.example.Project3.DatabaseHelper" %>
<%@ page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">
    <link rel="shortcut icon" type="image/png" href="images/favicon.jpeg">
    <title>Product Details Page</title>
</head>

<header>
    <h1 class="boba-header">Unoriginal Boba Store</h1>

    <div class="navbar-container">

        <a class="navbar" href="about.html">About Us</a>
        <a class="navbar" href="team.html">The Team</a>
        <a class="navbar" href="index.jsp">Menu</a>
    </div>
</header>

<body>
<%-- We do not use the 2 statements below since we're grabbing the user's input for pid via getParameter() method on line 46 --%>
<%--<jsp:useBean id="pid" class="com.example.Project3.ProductIdentifierInfo" scope="page"/>
<jsp:setProperty name="pid" property="*"/>--%>

<%--database connectivity --%>
<%
    String tea = request.getParameter("pid");
    DatabaseHelper databaseHelper = new DatabaseHelper();
    Connection con = databaseHelper.getConnection();
    Statement statement = con.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM table_all_products WHERE id = \"" + tea + "\"");
%>


<%
    while(resultSet.next()) {%>

        <h2 style="text-align: center; font-family: Arial, Helvetica, sans-serif;"><%=resultSet.getString("id")%></h2>

        <img style= "width: 400px; height: 300px;" src=<%=resultSet.getString("picture1")%>>

        <img style= "width: 400px; height: 300px;" src=<%=resultSet.getString("picture2")%>>

        <p style="font-weight: bold; font-size: 20px;">
            $ <%=resultSet.getDouble("price")%>
        </p>

        <p><%=resultSet.getString("description")%> </p>

        <form action="./CheckoutServlet" method="post">
            <input type="submit" name="button" value="Add <%=request.getParameter("pid")%> to Cart">
        </form>
<%
    }
%>
</body>


<footer>
    <br>
    <p> 123 Sesame Street, Imagination Land, 123456</p>
    <p>HOURS: 9AM-9PM DAILY</p>
    <p >© 2021 POWERED BY THE UNORIGINAL BOBA STORE</p>
</footer>

</html>