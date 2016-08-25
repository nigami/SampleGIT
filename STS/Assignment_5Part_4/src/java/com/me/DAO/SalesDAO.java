/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.Sales;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avanish
 */
public class SalesDAO extends CsvDAO{
   
    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatementforRecords;
    ResultSet resultSet;
    ResultSet rsForRecord;
    private ArrayList<Sales> salesList;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int noOfrecord;
    
    public SalesDAO(){
        
        
        
    }
    
    public void addToDb(ArrayList<String> items){
        
        
        
        String driver = "com.mysql.jdbc.Driver";
    String dburl= "jdbc:mysql://localhost:3306/salesDb";
    String dbuser= "root";
    String dbpassword="webtools";
    Connection conn=null;
      try {
            Class.forName(driver);
        try {
            conn=DriverManager.getConnection(dburl,dbuser,dbpassword);
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      for(int i=0;i<items.size();i=i+24)
      {
      
          
          
          
      String query = "insert into orderSales(salesOrderId,revisionNumber,orderDate,dueDate,shipDate,"
                    + "status,onlineOrderFlag,salesOrderNumber,purchaseOrderNumber,accountNumber,customerId,"
                    + "salesPersonId,territoryId,billToAddressId,shipToAddressId,shipMethodId,creditCardId,"
                    + "creditCardApprovalCode,currencyRateId,SubTotal,taxAmt,freight,totalDue,comment,modifiedDate)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      try {
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, Integer.valueOf(items.get(0)));
                preparedStatement.setInt(2,Integer.valueOf(items.get(1)));
                preparedStatement.setString(3,(((items.get(2)))));
                preparedStatement.setString(4,(items.get(3)));
                preparedStatement.setString(5,(items.get(4)));
                preparedStatement.setLong(6,(Long.valueOf(items.get(5))));
                preparedStatement.setLong(7,(Long.valueOf(items.get(6))));
                preparedStatement.setString(8,(items.get(7)));
                preparedStatement.setString(9,(items.get(8)));
                preparedStatement.setString(10,(items.get(9)));
                preparedStatement.setInt(11,(Integer.valueOf(items.get(10))));
                preparedStatement.setString(12,(items.get(11)));
                preparedStatement.setLong(13,(Long.valueOf(items.get(12))));
                preparedStatement.setLong(14,(Long.valueOf(items.get(13))));
                preparedStatement.setLong(15,(Long.valueOf(items.get(14))));
                preparedStatement.setLong(16,(Long.valueOf(items.get(15))));
                preparedStatement.setString(17,(items.get(16)));
                preparedStatement.setString(18,(items.get(17)));
                preparedStatement.setString(19,(items.get(18)));
                preparedStatement.setString(20,((items.get(19))));
                preparedStatement.setString(21,((items.get(20))));
                preparedStatement.setString(22,((items.get(21))));
                preparedStatement.setString(23,((items.get(22))));
                preparedStatement.setString(24,(items.get(23)));
                preparedStatement.setString(25,((items.get(24))));
                
                
                //System.out.println("Querry is "+query);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
      
       if(conn != null)
        {            
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
            if(resultSet!=null){
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      }
    }
    }
   
    
    public int getnoOfRecords(){
        
        
        return noOfrecord;
        
    }
    
    public ArrayList<Sales> getDetailsFromCsv(int offset){
        
        try {
            salesList = new ArrayList<>();
            
            connection = getConnection();
            //System.out.println("Connecton "+connection);
            
            String query="select * from SalesOrder LIMIT 100 offset "+offset+"";
             String noOfrecordQuery = "select count(*) from SalesOrder";
            
            //System.out.println("quey "+query);
            preparedStatementforRecords=connection.prepareStatement(noOfrecordQuery);
            rsForRecord=preparedStatementforRecords.executeQuery();
            while(rsForRecord.next()){
                
                
                noOfrecord = rsForRecord.getInt(1);
                
            }
            
            preparedStatement = connection.prepareStatement(query);
            
            resultSet=(ResultSet)preparedStatement.executeQuery();
            
     
            while (resultSet.next()) {
                Sales sales = new Sales();
              
                sales.setSalesOrderId(Integer.valueOf(resultSet.getString("SalesOrderID")));
                sales.setRevisionNumber(Integer.valueOf(resultSet.getString("RevisionNumber")));
                try {
                    sales.setOrderDate(sdf.parse(resultSet.getString("OrderDate")));
                    sales.setDueDate(sdf.parse(resultSet.getString("DueDate")));
                    sales.setShipDate(sdf.parse(resultSet.getString("ShipDate")));
                    sales.setModifiedDate(sdf.parse(resultSet.getString("ModifiedDate")));
                } catch (ParseException ex) {
                    Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                sales.setStatus(Integer.parseInt(resultSet.getString("Status")));
                sales.setOnlineOrderFlag(Integer.valueOf(resultSet.getString("OnlineOrderFlag")));
                
                sales.setSalesOrderNumber(resultSet.getString("SalesOrderNumber"));
                sales.setPurchaseOrderNumber(resultSet.getString("PurchaseOrderNumber"));
                sales.setAccountNumber((resultSet.getString("AccountNumber")));
                sales.setCustomerId(Integer.valueOf(resultSet.getString("CustomerID")));
                sales.setSalesPersonId(resultSet.getString("SalesPersonID"));
                sales.setTerritoryId(Integer.valueOf(resultSet.getString("TerritoryID")));
                sales.setBillToAddressId(Integer.valueOf(resultSet.getString("BillToAddressID")));
                sales.setShipToAddressId(Integer.valueOf(resultSet.getString("ShipToAddressID")));
                sales.setShipMethodId(Integer.valueOf(resultSet.getString("ShipMethodID")));
                sales.setCreditCardId((resultSet.getString("CreditCardID")));
                sales.setCreditCardApprovalCode(resultSet.getString("CreditCardApprovalCode"));
                sales.setCurrencyRateId((resultSet.getString("CurrencyRateID")));
                sales.setSubTotal(Double.valueOf(resultSet.getString("SubTotal")));
                sales.setTaxAmt(Double.valueOf(resultSet.getString("TaxAmt")));
                sales.setFreight(Double.valueOf(resultSet.getString("Freight")));
                sales.setTotalDue(Double.valueOf(resultSet.getString("TotalDue")));   
                sales.setComment(resultSet.getString("Comment"));
              
                salesList.add(sales);
                
            }

               connection.close(); 

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try {
                
                resultSet.close();
                rsForRecord.close();
                preparedStatement.close();
                //connection.close();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return salesList;
    }
    
}
