/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.waktuku;

/**
 *
 * @author g
 */
import java.sql.*;
public class Logic {
    public static void main(String[] args) {
        
        try 
        (
                Connection connection=DriverManager.getConnection("jdbc:sqlite:sample.db");
                Statement statement=connection.createStatement();
        ){
            statement.setQueryTimeout(30);
//            
//            statement.executeUpdate("drop table if exists person");
//            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            
             while(rs.next())
            {
              // read the result set
              System.out.println("name = " + rs.getString("name"));
              System.out.println("id = " + rs.getInt("id"));
            }
        } 
        catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
