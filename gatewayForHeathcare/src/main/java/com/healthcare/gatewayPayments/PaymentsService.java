package com.healthcare.gatewayPayments;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayAuth.AuthFilter;
import com.healthcare.gatewayDeatils.DoctorDetails;
import com.healthcare.gatewayDeatils.PaymentsDetails;
import com.healthcare.gatewayDoctorAuth.DoctorAuthAppointment;
import com.healthcare.gatewayDoctorAuth.DoctorAuthDefult;
import com.healthcare.gatewayDoctorAuth.DoctorAuthDoctor;
import com.healthcare.gatewayDoctorAuth.DoctorAuthPAyment;
import com.healthcare.gatewayDoctorAuth.DoctorAuthUser;
import com.healthcare.gatewayPaymentsAuth.PaymentsAuth;
import com.healthcare.gatewayPaymentsAuth.PaymentsAuthAppointment;

@Path("paymentprof")
public class PaymentsService {

	String currentUser;
	PaymentsAuth paymentsService;
	
	private void setInterfaces() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "appoinment":
			paymentsService = new PaymentsAuthAppointment();
			break;
		case "payment":
			paymentsService = new PaymentsAuthAppointment();
			break;
		default:
			paymentsService = new PaymentsAuthAppointment();
			break;
		}
		
	}
	
	@GET
	public Response getPaymentsSpecData() {
		setInterfaces();
		System.out.println(currentUser);
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		return paymentsService.getPaymentsSpecData();
	}

	@POST
	@Path("add")
	public Response postUser(PaymentsDetails details) {
		setInterfaces();
		return paymentsService.postPayments(details);
	}

}
