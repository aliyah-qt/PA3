package com.example.Project3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "OrderHistoryServlet", value = "/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL="jdbc:mysql://localhost/all_products";


        //  Database credentials
        final String USER = "root";
        final String PASS = "Spra98nak6!";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println("<html lang = \"en\"> <head>");
        out.println("<meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
        out.println("</head>");

        out.println("<body>\n");

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT cart FROM table_form_info ORDER BY id DESC LIMIT 1 ";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String raw_cart = rs.getString("cart");
                String raw_cart2 = raw_cart.substring(1, raw_cart.length() - 1);
                String last = "";

                String[] splitted = raw_cart2.split(",");

                if(splitted.length >= 5){

                    for (int i = 0; i < 5; i++) {
                        if(i == 4){
                            last += splitted[i];
                        }
                        else{
                            last += splitted[i] + ", ";
                        }
                    }
                }
                else{
                    for (int i = 0; i < splitted.length; i++) {
                        if(i == splitted.length-1){
                            last += splitted[i];
                        }
                        else{
                            last += splitted[i] + ", ";
                        }
                    }
                }

                out.println("<p style=\"font-weight: bold; font-size: 20px;\"> Your recently purchased items: " + last + "</p>\n");
            }

            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
        }catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
