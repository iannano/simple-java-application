/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utils.ian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ian-Nano
 */
public class DBConnection {
    private Connection connection = null;
    private static DBConnection dBConnection = null;
    static final String DB_Url = "jdbc:mysql://localhost:3306/simple_application_java";
    static final String DB_User = "root";
    static final String DB_password = "";
 
    public DBConnection(){
        if(connection==null){
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(DB_Url, DB_User, DB_password);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    public static DBConnection getInstance(){
        DBConnection dBConnection1 = null;
        if(dBConnection == null){
            dBConnection = new DBConnection();
            dBConnection1 = dBConnection;
        }
        else{
            dBConnection1 = dBConnection;
        }
        return dBConnection1;
    }
    
    public Connection getConnection() throws SQLException{
        return this.connection;
    }
}
