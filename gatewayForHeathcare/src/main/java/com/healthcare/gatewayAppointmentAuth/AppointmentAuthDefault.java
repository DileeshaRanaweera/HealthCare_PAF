package com.healthcare.gatewayAppointmentAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.AppointmentDetails;

public class AppointmentAuthDefault implements AppointmentAuth {

	@Override
	public Response getAppointmentsSpecData() {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

	@Override
	public Response postAppointments(AppointmentDetails details) {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

}
