package com.healthcare.gatewayDoctorAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.DoctorDetails;

public interface DoctorAuth {

	public Response getDocSpecData();
	public Response postDoc(DoctorDetails doctorDetails);
}
