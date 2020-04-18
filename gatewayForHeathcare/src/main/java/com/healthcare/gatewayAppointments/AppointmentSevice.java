package com.healthcare.gatewayAppointments;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayAppointmentAuth.AppointmentAuth;
import com.healthcare.gatewayAppointmentAuth.AppointmentAuthAppointment;
import com.healthcare.gatewayAppointmentAuth.AppointmentAuthDefault;
import com.healthcare.gatewayAppointmentAuth.AppointmentAuthDoctor;
import com.healthcare.gatewayAuth.AuthFilter;
import com.healthcare.gatewayDeatils.AppointmentDetails;
import com.healthcare.gatewayDeatils.PaymentsDetails;
import com.healthcare.gatewayPaymentsAuth.PaymentsAuth;
import com.healthcare.gatewayPaymentsAuth.PaymentsAuthAppointment;

@Path("appointmentprof")
public class AppointmentSevice {

		String currentUser;
		AppointmentAuth appointmentsService;
		
		private void setInterfaces() {
			currentUser = AuthFilter.CurrentAuth;
			switch (currentUser) {
			case "appoinment":
				appointmentsService = new AppointmentAuthAppointment();
				break;
			case "doctor":
				appointmentsService = new AppointmentAuthDoctor();
				break;
			default:
				appointmentsService = new AppointmentAuthDefault();
				break;
			}
			
		}
		
		@GET
		public Response getAppointmentsSpecData() {
			setInterfaces();
			System.out.println(currentUser);
			System.out.println("xxxxxxxxxxxxxxxxxxxx");
			return appointmentsService.getAppointmentsSpecData();
		}

		@POST
		@Path("add")
		public Response postUser(AppointmentDetails details) {
			setInterfaces();
			return appointmentsService.postAppointments(details);
		}

}
