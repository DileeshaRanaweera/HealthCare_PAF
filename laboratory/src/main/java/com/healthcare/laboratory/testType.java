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
public class testType {

	private String labRegID;
	private String TestName;
	private String TestFee;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "testType[labRegID=" + labRegID + ", TestName=" + TestName + ", TestFee=" + TestFee + "]";
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
	 * @return the testName
	 */
	public String getTestName() {
		return TestName;
	}

	/**
	 * @param testName the testName to set
	 */
	public void setTestName(String testName) {
		TestName = testName;
	}

	/**
	 * @return the testFee
	 */
	public String getTestFee() {
		return TestFee;
	}

	/**
	 * @param testFee the testFee to set
	 */
	public void setTestFee(String testFee) {
		TestFee = testFee;
	}

}
