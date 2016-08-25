/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.relique.jdbc.csv.CsvDriver;
/**
 *
 * @author Avanish
 */
public class CsvDAO {
    
    private String dburl;
    private String dbuser;
    private String dbpassword;
    private String driver;
    
    public CsvDAO(){
        
        
        driver ="org.relique.jdbc.csv.CsvDriver";
        dburl="jdbc:relique:csv:C:\\Users\\Avanish\\Documents\\NetBeansProjects\\Assignment_4_Part4\\";
//        dbuser="root";
//        dbpassword="webtools";
        
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection(){
        
        
        Connection conn=null;
        
        try {
            //conn=DriverManager.getConnection("jdbc:relique:csv:" + args[0]);
            conn=DriverManager.getConnection(dburl);
        } catch (SQLException ex) {
            Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public void close(Connection connection){
        
        if(connection != null)
        {
            
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    public void close(Statement statement){
        if(statement!=null){
        try {
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    
    public void close(ResultSet resultSet){
        if(resultSet!=null){
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
