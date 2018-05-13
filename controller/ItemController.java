/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.thogakade_home.controller;

import edu.ijse.thogakade_home.DBConnetion.DBConnection;

import edu.ijse.thogakade_home.model.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lakshan Ranasinghe
 */
public class ItemController {

    public static int addItem(Item item) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO Item VALUES('" + item.getCode() + "','" + item.getDescription() + "','" + item.getUnitPrice() + "','" + item.getQtyOnHand() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;

    }

    public static Item searchItem(String code) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM Item WHERE code='" + code + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Item item = new Item(rst.getString("code"), rst.getString("description"), rst.getString("unitPrice"), rst.getString("qtyOnHand"));
            return item;
        } else {
            return null;
        }

    }

    public static int deleteItem(String code) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Item WHERE code='" + code + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    public static int updateItem(Item item) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE Item SET description='" + item.getDescription() + "',unitPrice='" + item.getUnitPrice() + "',qtyOnHand='" + item.getQtyOnHand() + "'WHERE code='"+item.getCode()+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    public static ArrayList<Item> viewAllItems() throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM Item";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {

            Item item = new Item(rst.getString("code"), rst.getString("description"), rst.getString("unitPrice"), rst.getString("qtyOnHand"));
            itemList.add(item);
        }
        return itemList;
    }
}
