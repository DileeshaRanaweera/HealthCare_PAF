package com.healthcare.gatewayDoctorAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.DoctorDetails;
/**
 * @author dyasa
 *
 */
public class DoctorAuthDoctor implements DoctorAuth {

	DoctorR doctorR = new DoctorR();
	
	@Override
	public Response getDocSpecData() {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

	@Override
	public Response postDoc(DoctorDetails doctorDetails) {
		// TODO Auto-generated method stub
		return doctorR.postDoctorDetails(doctorDetails);
	}

}
