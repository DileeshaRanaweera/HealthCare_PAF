package com.healthcare.gatewayDoctorAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.DoctorDetails;
/**
 * @author dyasa
 *
 */
public class DoctorAuthUser implements DoctorAuth {

	DoctorR doctorR = new DoctorR();

	@Override
	public Response getDocSpecData() {
		// TODO Auto-generated method stub
		return doctorR.getDoctorSpecData();
	}

	@Override
	public Response postDoc(DoctorDetails doctorDetails) {
		// TODO Auto-generated method stub
		return doctorR.postDoctorDetails(doctorDetails);
	}
	
}
