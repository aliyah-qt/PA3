<%--
  Created by IntelliJ IDEA.
  User: aliyahfaith
  Date: 5/15/21
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Project3.DatabaseHelper" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%--<%@ page import="org.glassfish.jersey.client.ClientConfig" %>--%>
<%@ page import="javax.ws.rs.client.Client" %>
<%@ page import="javax.ws.rs.client.ClientBuilder" %>
<%@ page import="javax.ws.rs.client.WebTarget" %>
<%@ page import="javax.ws.rs.core.MediaType" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.example.Project3.PurchaseOrderFormInfo" %>
<%--<%@ page import="com.sun.deploy.config.ClientConfig" %>--%>
<%@ page import="java.net.URI" %>
<%@ page import="javax.ws.rs.core.UriBuilder" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.nio.charset.Charset" %>

<%@ page import="org.json.JSONException" %>
<%@ page import="org.json.JSONObject" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.jpeg">

    <title>Order Details Page</title>
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


<%
    DatabaseHelper databaseHelper = new DatabaseHelper();
    Connection con = databaseHelper.getConnection();
    Statement statement = con.createStatement();
    String sql;
%>



<%
        String fName = request.getParameter("First Name");
        //BEAN way: String fName = purchaseOrderInfo.getFirstName();

        String lName = request.getParameter("Last Name");
        // String lName = purchaseOrderInfo.getLastName();

        String phoneNum = request.getParameter("Phone Number");
        // String phoneNum = purchaseOrderInfo.getPhoneNumber();

        String street = request.getParameter("Address Line 1");
        //String street = purchaseOrderInfo.getAddressLine1();

        String unit = request.getParameter("Address Line 2");
        //String unit = purchaseOrderInfo.getAddressLine2();

        String city = request.getParameter("City");
        //String city = purchaseOrderInfo.getCity();

        String state = request.getParameter("State");
        //String state = purchaseOrderInfo.getState();

        String zip = request.getParameter("Zip Code");
        //String zip = purchaseOrderInfo.getZipCode();

        String shipping = request.getParameter("Shipping Method");
        // String shipping = purchaseOrderInfo.getShipping();

        String creditCard = request.getParameter("Card Number");
        //String creditCard = purchaseOrderInfo.getCreditCard();

        String expireMonth = request.getParameter("Expiration Month");
        //String expireMonth = purchaseOrderInfo.getExpiryMonth();

        String expireYear = request.getParameter("Expiration Year");
        //String expireYear = purchaseOrderInfo.getExpiryYear();

        String expiration = expireMonth + expireYear;

        String sCode = request.getParameter("Security Code");
        //String sCode = purchaseOrderInfo.getSecurity();

        String cart = request.getSession(false).getAttribute("cart").toString();
%>

<%
    sql = "INSERT INTO table_form_info (fname,lname, phone, street, unit_num, city, state, zip, ship, card_num, expiration, security, cart) VALUES ('" + fName+ "', '" + lName +"', '" + phoneNum +"', '"+ street +"', '"+ unit +"', '"+ city +"', '"+ state +"', '"+ zip +"', '"+ shipping +"', '"+ creditCard +"', '"+ expiration +"', '"+ sCode +"', '" + cart +"')"; //update this to insert data
    PreparedStatement preparedStatement = con.prepareStatement(sql);
    preparedStatement.executeUpdate();
%>
<%


    InputStream is = new URL("http://localhost:8080/Project3_war_exploded/api/order/0").openStream();
    BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
        sb.append((char) cp);
    }
    String jsonText = sb.toString();
    JSONObject json = new JSONObject(jsonText);
    System.out.println(json.toString());


%>

<%

    String firstjson = json.get("firstName").toString();
    String lastjson = json.get("lastName").toString();
    String streetjson = json.get("addressLine1").toString();
    String unitjson = json.get("addressLine2").toString();
    String cityjson = json.get("city").toString();
    String statejson = json.get("state").toString();
    String zipjson = json.get("zipCode").toString();
    String shippingjson = json.get("shipping").toString();

%>

<h1>Order status:</h1>

<h2> Thank you <%= firstjson %> <%= lastjson %> for shopping with us at The Unoriginal Boba Store (: </h2>
<p>Your order of <%= cart %> has been placed!
    <br>
    Deliver To: <%=streetjson%> <%=unitjson%>
    <br>
                 <%=cityjson%>, <%=statejson%> <%=zipjson%>
    <br>
    Type of Shipping: <%= shippingjson%>
</p>
<p>
    <br>
</body>

<%
    preparedStatement.close();
    statement.close();
    con.close();
%>
<footer>
    <br>
    <p> 123 Sesame Street, Imagination Land, 123456</p>
    <p>HOURS: 9AM-9PM DAILY</p>
    <p >© 2021 POWERED BY THE UNORIGINAL BOBA STORE</p>
</footer>
</html>
