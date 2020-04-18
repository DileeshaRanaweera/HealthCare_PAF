package com.healthcare.gatewayDeatils;
/**
 * @author dyasa
 *
 */
public class DoctorDetails {

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
	//private double FeePerAppointment;
	private String username;
	private String password;
	
	
	//table doctor_days data
	private String DaysOfvisiting;
	private String daysId;
	
	//table doctor_days data
	private String FeeId;
	private double FeePerAppointment;
	
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDaysOfvisiting() {
		return DaysOfvisiting;
	}
	public void setDaysOfvisiting(String daysOfvisiting) {
		DaysOfvisiting = daysOfvisiting;
	}
	public String getDaysId() {
		return daysId;
	}
	public void setDaysId(String daysId) {
		this.daysId = daysId;
	}
	public String getFeeId() {
		return FeeId;
	}
	public void setFeeId(String feeId) {
		FeeId = feeId;
	}
	public double getFeePerAppointment() {
		return FeePerAppointment;
	}
	public void setFeePerAppointment(double feePerAppointment) {
		FeePerAppointment = feePerAppointment;
	}
	
	
	
	
	
	
}
