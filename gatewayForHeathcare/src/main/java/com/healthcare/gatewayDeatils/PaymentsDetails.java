package com.healthcare.gatewayDeatils;

public class PaymentsDetails {
	

	private int PaymentID;
	private String Name;
	private String CardNo;
	private int Cvc;
	private String Exp;
	private int AppointmentID;
	private float Amount;
	private String PayDate;
	private String Email;
	
	public int getPaymentID() {
		return PaymentID;
	}
	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public int getCvc() {
		return Cvc;
	}
	public void setCvc(int cvc) {
		Cvc = cvc;
	}
	public String getExp() {
		return Exp;
	}
	public void setExp(String exp) {
		Exp = exp;
	}
	public int getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		AppointmentID = appointmentID;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getPayDate() {
		return PayDate;
	}
	public void setPayDate(String payDate) {
		PayDate = payDate;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Payments [PaymentID=" + PaymentID + ", Name=" + Name + ", CardNo=" + CardNo + ", Cvc=" + Cvc + ", Exp="
				+ Exp + ", AppointmentID=" + AppointmentID + ", Amount=" + Amount + ", PayDate=" + PayDate + ", Email="
				+ Email + "]";
	}
	

}
