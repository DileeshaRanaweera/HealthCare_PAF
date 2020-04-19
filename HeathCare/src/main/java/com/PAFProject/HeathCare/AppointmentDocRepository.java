package com.PAFProject.HeathCare;

import java.util.ArrayList;

import java.util.List;
import java.sql.*;



public class AppointmentDocRepository {
	
	
	Connection con = null;
	
	public AppointmentDocRepository(){
		
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
	
	public List<AppointmentDoc> getDocAppointments(){
		
		List<AppointmentDoc> appointDocList = new ArrayList<>();
		String sql = "select * from appointmentdoc";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
				AppointmentDoc appDoc = new AppointmentDoc();
				appDoc.setAppDocId(rs.getInt(1));
				appDoc.setSpecialization(rs.getString(2));
				appDoc.setDocName(rs.getString(3));
				appDoc.setHospital(rs.getString(4));
				appDoc.setDate(rs.getString(5));
				appDoc.setPatientNIC(rs.getString(6));
				appDoc.setPatientName(rs.getString(7));
				appDoc.setPatientAge(rs.getInt(8));
				appDoc.setPatientEmail(rs.getString(9));
				appDoc.setPatientContact(rs.getInt(10));
				
				appointDocList.add(appDoc);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return appointDocList;
		
	}
	
	
	public AppointmentDoc getDocAppointment(int appDocId) {
		
		String sql = "select * from appointmentdoc where appDocId="+appDocId;
		AppointmentDoc appDoc = new AppointmentDoc();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				
				appDoc.setAppDocId(rs.getInt(1));
				appDoc.setSpecialization(rs.getString(2));
				appDoc.setDocName(rs.getString(3));
				appDoc.setHospital(rs.getString(4));
				appDoc.setDate(rs.getString(5));
				appDoc.setPatientNIC(rs.getString(6));
				appDoc.setPatientName(rs.getString(7));
				appDoc.setPatientAge(rs.getInt(8));
				appDoc.setPatientEmail(rs.getString(9));
				appDoc.setPatientContact(rs.getInt(10));
				
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return appDoc;
		
	}
	
	
	public void createDocAppointment(AppointmentDoc appDoc1) {
		
		String sql = "insert into appointmentdoc values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, appDoc1.getAppDocId());
			st.setString(2, appDoc1.getSpecialization());
			st.setString(3, appDoc1.getDocName());
			st.setString(4, appDoc1.getHospital());
			st.setString(5, appDoc1.getDate());
			st.setString(6, appDoc1.getPatientNIC());
			st.setString(7, appDoc1.getPatientName());
			st.setInt(8, appDoc1.getPatientAge());
			st.setString(9, appDoc1.getPatientEmail());
			st.setInt(10, appDoc1.getPatientContact());
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void updateDocAppointment(AppointmentDoc appDoc1) {
		
		String sql = "update appointmentdoc set patientEmail=?, patientContact=? where appDocId=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, appDoc1.getPatientEmail());
			st.setInt(2, appDoc1.getPatientContact());
			st.setInt(3, appDoc1.getAppDocId());
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void deleteDocAppointment(int appDocId) {
		
		String sql = "delete from appointmentdoc where appDocId=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,appDocId);
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	
	}

}
