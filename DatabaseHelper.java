package com.example.Project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHelper {

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "all_products", "root","Spra98nak6!");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
