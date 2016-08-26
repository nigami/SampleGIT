/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.CSVDriver;
import java.sql.*;
import org.relique.jdbc.csv.CsvDriver;
/**
 *
 * @author ila
 */
public class CSVDriver {
    
    

  public  ResultSet csvDriver(String fileName)
  {
    try
    {
      // Load the driver.
      Class.forName("org.relique.jdbc.csv.CsvDriver");

      // Create a connection. The first command line parameter is
      // the directory containing the .csv files.
      // A single connection is thread-safe for use by several threads.
      Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:");

      // Create a Statement object to execute the query with.
      // A Statement is not thread-safe.
      Statement stmt = conn.createStatement();

      // Select the ID and NAME columns from sample.csv
      ResultSet results = stmt.executeQuery("SELECT * FROM SalesOrder");
        System.out.println("Result in csvDriver is "+results);
      
      // Dump out the results to a CSV file with the same format
      // using CsvJdbc helper function
      //boolean append = true;
      //CsvDriver.writeToCsv(results, System.out, append);

      // Clean up
      conn.close();
      return results;
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
}

