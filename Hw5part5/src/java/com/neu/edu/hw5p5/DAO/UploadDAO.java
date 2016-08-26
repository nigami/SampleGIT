/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.hw5p5.DAO;

import com.neu.edu.hw5p5.pojo.SalesOrder;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ila
 */
public class UploadDAO{

//    Connection conn;
//    PreparedStatement ps;
//    ResultSet rs;
    
    Configuration cfg = new Configuration();
    SessionFactory sf = cfg.configure().buildSessionFactory();

    public void uploadDatatoDB(SalesOrder salesOrder) throws SQLException {
        Session hibsession = sf.openSession();
        Transaction tx = null;
        SalesOrder s=salesOrder;
        try {
            tx = hibsession.beginTransaction();
            hibsession.save(s);
            tx.commit();
            System.out.println("Account number in DAO "+s.getAccountnumber());
//            conn = getConnection();
//            
//            String query = "insert into salesorder (accountnumber,billtoaddressid,comment,creditcardapprovalcode,creditcardid,currencyrateid,customerid,duedate,freight,modifieddate,onlineorderflag,orderdate,purchaseordernumber,revisionnumber,salesorderid,salesordernumber,salespersonid,shipdate,shipmethodid,shiptoaddressid,status,subtotal,taxamt,territoryid,totaldue) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            ps.setString(1, s.getAccountnumber());
//            ps.setString(2, s.getBilltoaddressid());
//            ps.setString(3, s.getComment());
//            ps.setString(4, s.getCreditcardapprovalcode());
//            ps.setString(5, s.getCreditcardid());
//            ps.setString(6, s.getCurrencyrateid());
//            ps.setString(7, s.getCustomerid());
//            ps.setString(8, s.getDuedate());
//            ps.setString(9, s.getFreight());
//            ps.setString(10, s.getModifieddate());
//            ps.setString(11, s.getOnlineorderflag());
//            ps.setString(12, s.getOrderdate());
//            ps.setString(13, s.getPurchaseordernumber());
//            ps.setString(14, s.getRevisionnumber());
//            ps.setString(15, s.getSalesorderid());
//            ps.setString(16, s.getSalesordernumber());
//            ps.setString(17, s.getSalespersonid());
//            ps.setString(18, s.getShipdate());
//            ps.setString(19, s.getShipmethodid());
//            ps.setString(20, s.getShiptoaddressid());
//            ps.setString(21, s.getStatus());
//            ps.setString(22, s.getSubtotal());
//            ps.setString(23, s.getTaxamt());
//            ps.setString(24, s.getTerritoryid());
//            ps.setString(25, s.getTotaldue());
//
//            int result = ps.executeUpdate();
//            //System.out.println("result " + result);
//            if (result > 0) {
//                rs = ps.getGeneratedKeys();
//                rs.next();
//
//            }

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            close(conn);
hibsession.close();
//
//            ps.close();
//            rs.close();
        }

    }
}
