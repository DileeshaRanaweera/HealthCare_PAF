/**
 * 
 */
package com.healthcare.Hospital;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Rashmika
 *
 */
@XmlRootElement
public class HospitalFee {
	
	private String HFeeID;
	private String HRegID;
	private String HFee;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HospitalFee[HFeeID=" + HFeeID + ", HRegID=" + HRegID + ", HFee=" + HFee + "]";
	}


	/**
	 * @return the hFeeID
	 */
	public String getHFeeID() {
		return HFeeID;
	}


	/**
	 * @param hFeeID the hFeeID to set
	 */
	public void setHFeeID(String hFeeID) {
		HFeeID = hFeeID;
	}


	/**
	 * @return the hRegID
	 */
	public String getHRegID() {
		return HRegID;
	}


	/**
	 * @param hRegID the hRegID to set
	 */
	public void setHRegID(String hRegID) {
		HRegID = hRegID;
	}


	/**
	 * @return the hFee
	 */
	public String getHFee() {
		return HFee;
	}


	/**
	 * @param hFee the hFee to set
	 */
	public void setHFee(String hFee) {
		HFee = hFee;
	}
	
	
	

}
