package com.healthcare.gatewayAppointmentAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.AppointmentDetails;

public class AppointmentAuthDoctor implements AppointmentAuth {

	AppointmentD appointmentD = new AppointmentD();
	@Override
	public Response getAppointmentsSpecData() {
		// TODO Auto-generated method stub
		return appointmentD.getAppointmentsSpecData();
	}

	@Override
	public Response postAppointments(AppointmentDetails details) {
		// TODO Auto-generated method stub
		return appointmentD.postAppointmentDetails(details);
	}

}
