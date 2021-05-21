package com.example.Project3;

import com.example.Project3.DatabaseHelper;
import com.example.Project3.DatabaseUtils;
import com.example.Project3.PurchaseOrderFormInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final static String ALL_ORDERS_QUERY = "SELECT * FROM table_form_info";

    public static PurchaseOrderFormInfo getOrderByLatestId(int id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseHelper.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, "SELECT * FROM table_form_info ORDER BY id DESC LIMIT 1");

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    PurchaseOrderFormInfo order = new PurchaseOrderFormInfo();

                    order.setId(resultSet.getInt("id"));
                    order.setFirstName(resultSet.getString("fname"));
                    order.setLastName(resultSet.getString("lname"));
                    order.setPhoneNumber(resultSet.getString("phone"));
                    order.setAddressLine1(resultSet.getString("street"));
                    order.setAddressLine2(resultSet.getString("unit_num"));
                    order.setCity(resultSet.getString("city"));
                    order.setState(resultSet.getString("state"));
                    order.setZipCode(resultSet.getString("zip"));
                    order.setShipping(resultSet.getString("ship"));
                    order.setCreditCard(resultSet.getString("card_num"));
                    order.setExpiry(resultSet.getString("expiration"));
                    order.setSecurity(resultSet.getString("security"));

                    return order;

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {

                    // We will always close the connection once we are done interacting with the Database.
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static List<PurchaseOrderFormInfo> getAllOrders() {
        List<PurchaseOrderFormInfo> orders = new ArrayList<PurchaseOrderFormInfo>();

        Connection connection = DatabaseHelper.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_ORDERS_QUERY);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    PurchaseOrderFormInfo order = new PurchaseOrderFormInfo();

                    order.setId(resultSet.getInt("id"));
                    order.setFirstName(resultSet.getString("fname"));
                    order.setLastName(resultSet.getString("lname"));
                    order.setPhoneNumber(resultSet.getString("phone"));
                    order.setAddressLine1(resultSet.getString("street"));
                    order.setAddressLine2(resultSet.getString("unit_num"));
                    order.setCity(resultSet.getString("city"));
                    order.setState(resultSet.getString("state"));
                    order.setZipCode(resultSet.getString("zip"));
                    order.setShipping(resultSet.getString("ship"));
                    order.setCreditCard(resultSet.getString("card_num"));
                    order.setExpiry(resultSet.getString("expiration"));
                    order.setSecurity(resultSet.getString("security"));

                    orders.add(order);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return orders;
    }

    public static boolean deleteOrder(PurchaseOrderFormInfo retrievedOrder) {

        String sql = "DELETE FROM table_form_info WHERE id = ?;";

        Connection connection = DatabaseHelper.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, String.valueOf(retrievedOrder.getId()));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;
    }
}