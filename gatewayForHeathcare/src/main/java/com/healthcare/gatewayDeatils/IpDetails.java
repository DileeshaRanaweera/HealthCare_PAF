package com.healthcare.gatewayDeatils;

public class IpDetails {
	
	private String docIP;
	private String UserIP;
	private String LabIP;
	private String paymentIP;
	private String hospitalIP;
	private String appoimentIP;
	private String gatewayIP;
	
	
	public String getDocIP() {
		return docIP;
	}
	public void setDocIP(String docIP) {
		this.docIP = docIP;
	}
	public String getUserIP() {
		return UserIP;
	}
	public void setUserIP(String userIP) {
		UserIP = userIP;
	}
	public String getLabIP() {
		return LabIP;
	}
	public void setLabIP(String labIP) {
		LabIP = labIP;
	}
	public String getPaymentIP() {
		return paymentIP;
	}
	public void setPaymentIP(String paymentIP) {
		this.paymentIP = paymentIP;
	}
	public String getHospitalIP() {
		return hospitalIP;
	}
	public void setHospitalIP(String hospitalIP) {
		this.hospitalIP = hospitalIP;
	}
	public String getAppoimentIP() {
		return appoimentIP;
	}
	public void setAppoimentIP(String appoimentIP) {
		this.appoimentIP = appoimentIP;
	}
	public String getGatewayIP() {
		return gatewayIP;
	}
	public void setGatewayIP(String gatewayIP) {
		this.gatewayIP = gatewayIP;
	}
	
	@Override
	public String toString() {
		return "IpDetails [docIP=" + docIP + ", UserIP=" + UserIP + ", LabIP=" + LabIP + ", paymentIP=" + paymentIP
				+ ", hospitalIP=" + hospitalIP + ", appoimentIP=" + appoimentIP + ", gatewayIP=" + gatewayIP + "]";
	}
	
	

	
	
}
