/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.thogakade_home.controller;

import edu.ijse.thogakade_home.DBConnetion.DBConnection;
import edu.ijse.thogakade_home.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lakshan Ranasinghe
 */
public class CustomerController {

    public static int addCustomer(Customer customer) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO Customer VALUES('" + customer.getId() + "','" + customer.getName() + "','" + customer.getAddress() + "'," + customer.getSalary() + ")";
        DBConnection db = DBConnection.getDBConnection();
        Connection conn = db.getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);

        return res;
    }

    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM Customer WHERE id='" + id + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm;
        stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Customer customer;
            customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
            return customer;
        } else {

            return null;
        }

    }

    public static int deleteCustomer(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM customer WHERE id='" + id + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;

    }

    public static int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE customer SET name='" + customer.getName() + "',address='" + customer.getAddress() + "',salary='" + customer.getSalary() + "'WHERE id='" + customer.getId() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;

    }

    public static ArrayList<Customer> viewAllCustomers() throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM customer";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Customer> customerList = new ArrayList<>();

        while (rst.next()) {
            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
            customerList.add(customer);
        }
        
        return customerList;
    
    }
}
