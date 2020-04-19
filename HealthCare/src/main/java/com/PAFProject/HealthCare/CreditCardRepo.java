package com.PAFProject.HealthCare;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CreditCardRepo {
	
	Connection con = null;
	
	public CreditCardRepo() {
		
	String url = "jdbc:mysql://localhost:3306/creditdb";
	String username = "root";
	String password = "";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
	
	}catch(Exception e) {
		System.out.println(e);
		
	}
	}
	
	public List<CreditCard> getCreditDetails(){
		
		List<CreditCard> credit = new ArrayList<>();
		String sql = "select * from creditcarddetails";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				CreditCard c = new CreditCard();
				c.setCardNo(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setCVC(rs.getInt(3));
				c.setExp(rs.getString(4));
				
				credit.add(c);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return credit;
	}
	
	public CreditCard getCreditCard(int CardNo) {
		
		String sql = "select * from creditcarddetails where CardNo ="+CardNo;
		CreditCard c = new CreditCard();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				c.setCardNo(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setCVC(rs.getInt(3));
				c.setExp(rs.getString(4));
				
	
			}
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return c;
		
	}
	
	public void createDetails(CreditCard c) {
		
		String sql = "insert into creditcarddetails values (?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
		
				
				st.setInt(1,c.getCardNo());
				st.setString(2,c.getName());
				st.setInt(3,c.getCVC());
				st.setString(4,c.getExp());
				st.executeUpdate();
	
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
	}
	
	
}


