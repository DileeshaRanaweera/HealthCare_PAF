package com.healthcare.gatewayDeatils;
/**
 * @author kusal
 *
 */
public class UserDetails {

	private String nic; 
	private String fname;
	private String Lname; 
	private String address; 
	private String contact;
	private String gender;
	private String email;
	private String username;
	private String password;
	
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	@Override
	public String toString() {
		return "UserDetails [nic=" + nic + ", fname=" + fname + ", Lname=" + Lname + ", address=" + address
				+ ", contact=" + contact + ", gender=" + gender + ", email=" + email + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
