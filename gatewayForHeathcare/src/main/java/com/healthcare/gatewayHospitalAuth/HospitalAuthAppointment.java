/**
 * 
 */
package com.healthcare.gatewayHospitalAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.HospitalDetails;

/**
 * @author user
 *
 */
public class HospitalAuthAppointment implements HospitalAuth {

	HospitalR hospitalR = new HospitalR();
	
	@Override
	public Response getHospitalSpecData() {
		// TODO Auto-generated method stub
		return hospitalR.getHospitalSpecData();
	}

	@Override
	public Response postHospital(HospitalDetails hospitalDetails) {
		// TODO Auto-generated method stub
		return hospitalR.postHospitalDetails(hospitalDetails);
	}

}
