/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.controller.AddToDb;
import com.me.pojo.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Avanish
 */
public class AddBooksDAO {
    
    Configuration cfg = new Configuration();
    SessionFactory sf = cfg.configure().buildSessionFactory();

    public void addBook(String[] isbnVal,String[] titleVal,String[] authorVal,String[] priceVal) throws SQLException {
        
        ArrayList<Book> bookList = new ArrayList<>();
        for (int i = 0; i < isbnVal.length; i++) {
            Book book = new Book();
            
            String isbn = isbnVal[i];
            String title = titleVal[i];
            String authors = authorVal[i];
            String price = priceVal[i];
            book.setAuthors(authors);
            book.setBookTitle(title);
            book.setIsbn((isbn));
            book.setPrice(Float.parseFloat(price));  
            bookList.add(book);
        }
        
        Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = hibsession.beginTransaction();
            
            for(Book b:bookList)
            {
                hibsession.save(b);
            }
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            hibsession.close();
        }

    }
    
    
}
