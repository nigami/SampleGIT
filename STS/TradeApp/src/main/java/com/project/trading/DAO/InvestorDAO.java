package com.project.trading.DAO;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.project.trading.exception.AdException;
import com.project.trading.pojo.Investor;
import com.project.trading.pojo.User;

public class InvestorDAO extends DAO{
	
	public InvestorDAO()
	{
		
	}
	
	public Investor createInvestor(String fName,String lName,String eMailID,String userName,String password,String contact, String panCardNum, String accountNum, String address)
	{
		    int randomNum = 1000 + (int)(Math.random() * 2000);
			Date d = new Date();
			begin();
            Investor investor=new Investor();
            investor.setfName(fName);
            investor.setlName(lName);
            investor.seteMailID(eMailID);
            investor.setUserName(userName);
            investor.setPassword(password);
            investor.setContact(contact);
            investor.setPanCardNum(panCardNum);
            investor.setAccountNum(accountNum);
            investor.setAddress(address);
            investor.setDate(d);
            investor.setAmount("$"+randomNum+".00");
            getSession().save(investor);
            commit();
            return investor;
        
	}
	
	public Investor findInvestor(String username,String pw) throws AdException
	{
		try{
			begin();
			Query q = getSession().createQuery("from User u where userName = :username and password = :pass");
			q.setString("username",username);
			q.setString("pass", pw);
			System.out.println(username);
			System.out.println(pw);
			User user=(User) q.uniqueResult();
			//List results=q.list();
			commit();
			
			
			if(user!=null)
				{
				String ids=String.valueOf(user.getUserId());
				System.out.println("the ids is "+ids);
				begin();
				Query query = getSession().createQuery("from Investor where userId = :uId");
				query.setString("uId",ids);
				Investor investor=(Investor) query.uniqueResult();
				System.out.println("the investor is "+investor);
				commit();
				return investor;
				}
			else
				{System.out.println("the user is null");
				return null;}
		   }
		catch(HibernateException e)
		{
			rollback();
			throw new AdException("Could not get user " + username, e);
		}
		
	}

}
