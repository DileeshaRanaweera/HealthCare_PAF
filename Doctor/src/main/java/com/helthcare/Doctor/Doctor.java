package com.helthcare.Doctor;

import java.sql.Date;
import java.sql.Time;

import javax.security.auth.PrivateCredentialPermission;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {
	//table doctortale data
	private String NIC;
	private String MedicalId ;
	private String FirstName;
	private String LastName;
	private String gender;
	private String address;
	private String contact;
	private String Email;
	private String Specialization;
	private String Hospital;
	private String StartingTime;
	private String EndTime;
	private int  AppointmentAmount;
	private String username;
	private String Docpassword;
	
	
	//getters & setters doctortable
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getMedicalId() {
		return MedicalId;
	}
	public void setMedicalId(String medicalId) {
		MedicalId = medicalId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getHospital() {
		return Hospital;
	}
	public void setHospital(String hospital) {
		Hospital = hospital;
	}
	public String getStartingTime() {
		return StartingTime;
	}
	public void setStartingTime(String startingTime) {
		StartingTime = startingTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public int getAppointmentAmount() {
		return AppointmentAmount;
	}
	public void setAppointmentAmount(int appointmentAmount) {
		AppointmentAmount = appointmentAmount;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Docpassword;
	}
	public void setPassword(String password) {
		this.Docpassword = password;
	}
	
	
	
	

	
	
	

}
