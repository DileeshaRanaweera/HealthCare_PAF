package com.healthcare.gatewayAppointmentAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.AppointmentDetails;


public interface AppointmentAuth {
	
	public Response getAppointmentsSpecData();
	public Response postAppointments(AppointmentDetails details);

}
