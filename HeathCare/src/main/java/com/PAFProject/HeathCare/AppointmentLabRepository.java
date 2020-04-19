package com.PAFProject.HeathCare;

import java.util.ArrayList;

import java.util.List;
import java.sql.*;


public class AppointmentLabRepository {

Connection con = null;
	
	public AppointmentLabRepository(){
		
		String url = "jdbc:mysql://localhost:3306/appointmentdb";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public List<AppointmentLab> getLabAppointments(){
		
		List<AppointmentLab> appointLabList = new ArrayList<>();
		String sql = "select * from appointmentlab";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
				AppointmentLab appLab = new AppointmentLab();
				appLab.setAppLabId(rs.getInt(1));
				appLab.setLabName(rs.getString(2));
				appLab.setTestType(rs.getString(3));
				appLab.setDate(rs.getString(4));
				appLab.setPatientNIC(rs.getString(5));
				appLab.setPatientName(rs.getString(6));
				appLab.setPatientAge(rs.getInt(7));
				appLab.setPatientEmail(rs.getString(8));
				appLab.setPatientContact(rs.getInt(9));
				
				appointLabList.add(appLab);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return appointLabList;
		
	}
	
	
	public AppointmentLab getLabAppointment(int appLabId) {
		
		String sql = "select * from appointmentlab where appLabId="+appLabId;
		AppointmentLab appLab = new AppointmentLab();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				
				
				appLab.setAppLabId(rs.getInt(1));
				appLab.setLabName(rs.getString(2));
				appLab.setTestType(rs.getString(3));
				appLab.setDate(rs.getString(4));
				appLab.setPatientNIC(rs.getString(5));
				appLab.setPatientName(rs.getString(6));
				appLab.setPatientAge(rs.getInt(7));
				appLab.setPatientEmail(rs.getString(8));
				appLab.setPatientContact(rs.getInt(9));
				
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return appLab;
		
	}
	
	
	public void createLabAppointment(AppointmentLab appLab1) {
		
		String sql = "insert into appointmentlab values (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, appLab1.getAppLabId());
			st.setString(2, appLab1.getLabName());
			st.setString(3, appLab1.getTestType());
			
			st.setString(4, appLab1.getDate());
			st.setString(5, appLab1.getPatientNIC());
			st.setString(6, appLab1.getPatientName());
			st.setInt(7, appLab1.getPatientAge());
			st.setString(8, appLab1.getPatientEmail());
			st.setInt(9, appLab1.getPatientContact());
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void updateLabAppointment(AppointmentLab appLab1) {
		
		String sql = "update appointmentlab set patientEmail=?, patientContact=? where appLabId=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, appLab1.getPatientEmail());
			st.setInt(2, appLab1.getPatientContact());
			st.setInt(3, appLab1.getAppLabId());
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void deleteLabAppointment(int appLabId) {
		
		String sql = "delete from appointmentlab where appLabId=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,appLabId);
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	
	}
	
	
	
}
