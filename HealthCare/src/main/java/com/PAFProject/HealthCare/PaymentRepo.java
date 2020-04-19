package com.PAFProject.HealthCare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepo {
	
Connection con = null;
	
	public PaymentRepo() {
		
	String url = "jdbc:mysql://localhost:3306/paymentdb";
	String username = "root";
	String password = "";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
	
	}catch(Exception e) {
		System.out.println(e);
		
	}
}
	
	public List<Payments> getAllPayments(){
		
		List<Payments> payment = new ArrayList<>();
		String sql = "select PaymentID,Name,CardNo,AppointmentID,Amount,PayDate,Email from paymentdetails";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Payments p = new Payments();
				p.setPaymentID(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCardNo(rs.getString(3));
				p.setAppointmentID(rs.getInt(4));
				p.setAmount(rs.getFloat(5));
				p.setPayDate(rs.getString(6));
				p.setEmail(rs.getString(7));
				
				payment.add(p);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return payment;
	}
	
	public Payments getPayment(int PaymentID) {
		
		String sql = "select PaymentID,Name,CardNo,AppointmentID,Amount,PayDate,Email from paymentdetails where PaymentID ="+PaymentID;
		Payments p = new Payments();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				p.setPaymentID(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCardNo(rs.getString(3));
				p.setAppointmentID(rs.getInt(4));
				p.setAmount(rs.getFloat(5));
				p.setPayDate(rs.getString(6));
				p.setEmail(rs.getString(7));
				
	
			}
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return p;
		
	}
	
	public void createPayments(Payments p) {
		
		String sql = "insert into paymentdetails values (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
		
				
				st.setInt(1,p.getPaymentID());
				st.setString(2,p.getName());
				st.setString(3,p.getCardNo());
				st.setInt(4,p.getCvc());
				st.setString(5,p.getExp());
				st.setInt(6,p.getAppointmentID());
				st.setFloat(7,p.getAmount());
				st.setString(8,p.getPayDate());
				st.setString(9,p.getEmail());
				st.executeUpdate();
	
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
	}

	public void updatePayments(Payments p) {
		
		String sql = "update paymentdetails set Email=? where PaymentID=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1,p.getEmail());
				st.setInt(2,p.getPaymentID());
				st.executeUpdate();
	
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
	}
	
		public void deletePayments(int PaymentID) {
		
		String sql = "delete from paymentdetails where PaymentID=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1,PaymentID);
				st.executeUpdate();
	
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
	}
	

}
