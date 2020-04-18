/**
 * 
 */
package com.healthcare.gatewayHospitalAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.HospitalDetails;

/**
 * @author Rashmika
 *
 */
public class HospitalAuthDefault implements HospitalAuth {

	@Override
	public Response getHospitalSpecData() {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();

	}

	@Override
	public Response postHospital(HospitalDetails hospitalDetails) {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

}
