/**
 * 
 */
package com.healthcare.laboratory;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author oshadi
 *
 */
@XmlRootElement
public class Lab {
	
	private String labRegID;
	private String labName;
	private String labAddress;
	private String labCity;
	private String labDestrict;
	private String labProvince;
	private String labEmail;
	private String labContactNum;
	private String labUsername;
	private String labPassword;
	private String OpenTime;
	private String CloseTime;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Lab[labRegID=" + labRegID + ", labName=" + labName + ", labAddress=" + labAddress + ", labCity="
		+ labCity + ", labDestrict=" + labDestrict + ", labProvince=" + labProvince + ", labEmail=" + labEmail
		+ ", labContactNum=" + labContactNum + ", labUsername =" + labUsername + ", "
				+ "labPassword = " + labPassword + ", OpenTime=" + OpenTime + ", CloseTime=" + CloseTime + "]";
}


	/**
	 * @return the labRegID
	 */
	public String getLabRegID() {
		return labRegID;
	}


	/**
	 * @param labRegID the labRegID to set
	 */
	public void setLabRegID(String labRegID) {
		this.labRegID = labRegID;
	}


	/**
	 * @return the labName
	 */
	public String getLabName() {
		return labName;
	}


	/**
	 * @param labName the labName to set
	 */
	public void setLabName(String labName) {
		this.labName = labName;
	}


	/**
	 * @return the labAddress
	 */
	public String getLabAddress() {
		return labAddress;
	}


	/**
	 * @param labAddress the labAddress to set
	 */
	public void setLabAddress(String labAddress) {
		this.labAddress = labAddress;
	}


	/**
	 * @return the labCity
	 */
	public String getLabCity() {
		return labCity;
	}


	/**
	 * @param labCity the labCity to set
	 */
	public void setLabCity(String labCity) {
		this.labCity = labCity;
	}


	/**
	 * @return the labDestrict
	 */
	public String getLabDestrict() {
		return labDestrict;
	}


	/**
	 * @param labDestrict the labDestrict to set
	 */
	public void setLabDestrict(String labDestrict) {
		this.labDestrict = labDestrict;
	}


	/**
	 * @return the labProvince
	 */
	public String getLabProvince() {
		return labProvince;
	}


	/**
	 * @param labProvince the labProvince to set
	 */
	public void setLabProvince(String labProvince) {
		this.labProvince = labProvince;
	}


	/**
	 * @return the labEmail
	 */
	public String getLabEmail() {
		return labEmail;
	}


	/**
	 * @param labEmail the labEmail to set
	 */
	public void setLabEmail(String labEmail) {
		this.labEmail = labEmail;
	}


	/**
	 * @return the labContactNum
	 */
	public String getLabContactNum() {
		return labContactNum;
	}


	/**
	 * @param labContactNum the labContactNum to set
	 */
	public void setLabContactNum(String labContactNum) {
		this.labContactNum = labContactNum;
	}


	/**
	 * @return the labUsername
	 */
	public String getLabUsername() {
		return labUsername;
	}


	/**
	 * @param labUsername the labUsername to set
	 */
	public void setLabUsername(String labUsername) {
		this.labUsername = labUsername;
	}


	/**
	 * @return the labPassword
	 */
	public String getLabPassword() {
		return labPassword;
	}


	/**
	 * @param labPassword the labPassword to set
	 */
	public void setLabPassword(String labPassword) {
		this.labPassword = labPassword;
	}


	/**
	 * @return the openTime
	 */
	public String getOpenTime() {
		return OpenTime;
	}


	/**
	 * @param openTime the openTime to set
	 */
	public void setOpenTime(String openTime) {
		OpenTime = openTime;
	}


	/**
	 * @return the closeTime
	 */
	public String getCloseTime() {
		return CloseTime;
	}


	/**
	 * @param closeTime the closeTime to set
	 */
	public void setCloseTime(String closeTime) {
		CloseTime = closeTime;
	}
	
	

}
