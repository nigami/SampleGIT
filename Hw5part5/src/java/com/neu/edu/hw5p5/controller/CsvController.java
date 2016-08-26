/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.hw5p5.controller;

import com.neu.edu.CSVDriver.CSVDriver;
import com.neu.edu.hw5p5.DAO.UploadDAO;
import com.neu.edu.hw5p5.pojo.SalesOrder;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author ila
 */
public class CsvController implements Controller {

    UploadDAO uploadDAO;
    CSVDriver csvDriver;

    public CsvController(UploadDAO uploadDAO, CSVDriver csvDriver) {
        this.uploadDAO = uploadDAO;
        this.csvDriver = csvDriver;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");
        String fileName;

        int k = 1;
        int rows = 0;
        ModelAndView mv = new ModelAndView();
        int content;
        int pageNumberDisplay;
        if (action.equals("showDetails")) {

            int paginationButtons;

            if (hsr.getParameter("entryPage").equals("true")) {
                fileName = hsr.getParameter("fileName");
                session.setAttribute("fileName", fileName);

                try {
                    Class.forName("org.relique.jdbc.csv.CsvDriver");
                    Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + fileName);

                    int totalRows = 0;
                    while (rs.next()) {
                        totalRows += 1;
                    }
                    content = Integer.parseInt(hsr.getParameter("defaultContent"));
                    
                    pageNumberDisplay = content * 100;
                    rs = stmt.executeQuery("SELECT * FROM " + fileName + " LIMIT 100 OFFSET " + pageNumberDisplay);
                    ArrayList<SalesOrder> salesOrderArrayList = new ArrayList<>();

                    while (rs.next()) {
                        SalesOrder s = new SalesOrder();
                        s.setAccountnumber(rs.getString("accountnumber"));
                        s.setBilltoaddressid(rs.getString("billtoaddressid"));
                        s.setComment(rs.getString("comment"));
                        s.setCreditcardapprovalcode(rs.getString("creditcardapprovalcode"));
                        s.setCreditcardid(rs.getString("creditcardid"));
                        s.setCurrencyrateid(rs.getString("currencyrateid"));
                        s.setCustomerid(rs.getString("customerid"));
                        s.setDuedate(rs.getString("duedate"));
                        s.setFreight(rs.getString("freight"));
                        s.setModifieddate(rs.getString("modifieddate"));
                        s.setOnlineorderflag(rs.getString("onlineorderflag"));
                        s.setOrderdate(rs.getString("orderdate"));
                        s.setPurchaseordernumber(rs.getString("purchaseordernumber"));
                        s.setRevisionnumber(rs.getString("revisionnumber"));
                        s.setSalesorderid(rs.getString("salesorderid"));
                        s.setSalesordernumber(rs.getString("salesordernumber"));
                        s.setSalespersonid(rs.getString("salespersonid"));
                        s.setShipdate(rs.getString("shipdate"));
                        s.setShipmethodid(rs.getString("shipmethodid"));
                        s.setShiptoaddressid(rs.getString("shiptoaddressid"));
                        s.setStatus(rs.getString("status"));
                        s.setSubtotal(rs.getString("subtotal"));
                        s.setTaxamt(rs.getString("taxamt"));
                        s.setTerritoryid(rs.getString("territoryid"));
                        s.setTotaldue(rs.getString("totaldue"));
                        salesOrderArrayList.add(s);
                        rows = rows + 1;

                    }

                    session.setAttribute("salesOrderList", salesOrderArrayList);
                    session.setAttribute("rowsDisplayed", 100);
                    session.setAttribute("defaultContent", content + 1);
                    String pageNumber = "a";
                    hsr.setAttribute("pageNumber", pageNumber);
                    mv.setViewName("index");
                    conn.close();

                    if (totalRows % 100 == 0) {
                        paginationButtons = totalRows / 100;
                        session.setAttribute("paginationButtons", paginationButtons);
                    } else {
                        paginationButtons = Math.floorDiv(totalRows, 100) + 1;
                        session.setAttribute("paginationButtons", paginationButtons);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                fileName = (String) session.getAttribute("fileName");

                
                content=(Integer)session.getAttribute("defaultContent");
                //content=Integer.parseInt(hsr.getParameter("content"));
                pageNumberDisplay = content * 100;
                try {

                    Class.forName("org.relique.jdbc.csv.CsvDriver");

                    Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:");

                    Statement stmt = conn.createStatement();

                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + fileName + " LIMIT 100 OFFSET " + pageNumberDisplay);

                    ArrayList<SalesOrder> salesOrderArrayList = new ArrayList<>();

                    while (rs.next()) {
                        SalesOrder s = new SalesOrder();
                        s.setAccountnumber(rs.getString("accountnumber"));
                        s.setBilltoaddressid(rs.getString("billtoaddressid"));
                        s.setComment(rs.getString("comment"));
                        s.setCreditcardapprovalcode(rs.getString("creditcardapprovalcode"));
                        s.setCreditcardid(rs.getString("creditcardid"));
                        s.setCurrencyrateid(rs.getString("currencyrateid"));
                        s.setCustomerid(rs.getString("customerid"));
                        s.setDuedate(rs.getString("duedate"));
                        s.setFreight(rs.getString("freight"));
                        s.setModifieddate(rs.getString("modifieddate"));
                        s.setOnlineorderflag(rs.getString("onlineorderflag"));
                        s.setOrderdate(rs.getString("orderdate"));
                        s.setPurchaseordernumber(rs.getString("purchaseordernumber"));
                        s.setRevisionnumber(rs.getString("revisionnumber"));
                        s.setSalesorderid(rs.getString("salesorderid"));
                        s.setSalesordernumber(rs.getString("salesordernumber"));
                        s.setSalespersonid(rs.getString("salespersonid"));
                        s.setShipdate(rs.getString("shipdate"));
                        s.setShipmethodid(rs.getString("shipmethodid"));
                        s.setShiptoaddressid(rs.getString("shiptoaddressid"));
                        s.setStatus(rs.getString("status"));
                        s.setSubtotal(rs.getString("subtotal"));
                        s.setTaxamt(rs.getString("taxamt"));
                        s.setTerritoryid(rs.getString("territoryid"));
                        s.setTotaldue(rs.getString("totaldue"));
                        salesOrderArrayList.add(s);
                        rows = rows + 1;

                    }

                    int rowsDisplayed = pageNumberDisplay + 100;
                    System.out.println(content + "default Content");
                    session.setAttribute("defaultContent", content + 1);
                    session.setAttribute("rowsDisplayed", rowsDisplayed);
                    JSONObject obj = new JSONObject();
                    obj.put("salesOrderList", salesOrderArrayList);
                    obj.put("countForMoreRows", pageNumberDisplay);
                    PrintWriter out = hsr1.getWriter();
                    out.print(obj);
                    String pageNumber = "a";
                    session.setAttribute("paginationHelp", content);
                    hsr.setAttribute("pageNumber", pageNumber);
                    mv.setViewName("index");
                    conn.close();
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        SalesOrder s = new SalesOrder();
        if (action.equals("addToDB")) {
            String pageNumber = "b";
            hsr.setAttribute("pageNumber", pageNumber);

            System.out.println("account number " + hsr.getParameter("accountnumber"));
            s.setAccountnumber(hsr.getParameter("accountnumber"));
            System.out.println("Account number from bean=" + s.getAccountnumber());
            s.setBilltoaddressid(hsr.getParameter("billtoaddressid"));
            s.setComment(hsr.getParameter("comment"));
            s.setCreditcardapprovalcode(hsr.getParameter("creditcardapprovalcode"));
            s.setCreditcardid(hsr.getParameter("creditcardid"));
            s.setCurrencyrateid(hsr.getParameter("currencyrateid"));
            s.setCustomerid(hsr.getParameter("customerid"));
            s.setDuedate(hsr.getParameter("duedate"));
            s.setFreight(hsr.getParameter("freight"));
            s.setModifieddate(hsr.getParameter("modifieddate"));
            s.setOnlineorderflag(hsr.getParameter("onlineorderflag"));
            s.setOrderdate(hsr.getParameter("orderdate"));
            s.setPurchaseordernumber(hsr.getParameter("purchaseordernumber"));
            s.setRevisionnumber(hsr.getParameter("revisionnumber"));
            s.setSalesorderid(hsr.getParameter("salesorderid"));
            s.setSalesordernumber(hsr.getParameter("salesordernumber"));
            s.setSalespersonid(hsr.getParameter("salespersonid"));
            s.setShipdate(hsr.getParameter("shipdate"));
            s.setShipmethodid(hsr.getParameter("shipmethodid"));
            s.setShiptoaddressid(hsr.getParameter("shiptoaddressid"));
            s.setStatus(hsr.getParameter("status"));
            s.setSubtotal(hsr.getParameter("subtotal"));
            s.setTaxamt(hsr.getParameter("taxamt"));
            s.setTerritoryid(hsr.getParameter("territoryid"));
            s.setTotaldue(hsr.getParameter("totaldue"));
            uploadDAO.uploadDatatoDB(s);

            // }
            // hsr.setAttribute("rowsAdded", salesOrderArrayList.size());
            mv.setViewName("index");//dbUpdated
        }
        return mv;
    }

}
