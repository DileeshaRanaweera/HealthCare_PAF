package com.healthcare.gatewayAppointmentAuth;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.AppointmentDetails;
import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;
import com.healthcare.gatewayDeatils.PaymentsDetails;

public class AppointmentD {

	String API;
	Client client = ClientBuilder.newClient();
	

	public AppointmentD() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getAppoimentIP();
	}
	
	public final Response getAppointmentsSpecData() {
		WebTarget service = client.target(API).path("appoiment");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	public final Response postAppointmentDetails(AppointmentDetails appointmentsDetails) {
		WebTarget service = client.target(API).path("appoiment").path("add");
		try {
			Response response = service.request().post(Entity.json(appointmentsDetails));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
