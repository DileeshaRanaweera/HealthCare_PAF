package com.healthcare.gatewayAuth;
/**
 * @author kusal
 *
 */
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;

public class AuthClient {

	String API;
	String DoctorIP;
	String AppointmentIP;
	String PaymentsIP;
	Client client = ClientBuilder.newClient();

	public AuthClient() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getUserIP();
		DoctorIP = ipDetails.getHospitalIP();
	}

	public final String AuthChecker(String authToken) {
		System.out.println(API);
		WebTarget service = client.target(API).path("check").queryParam("token", authToken);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			return null;
		}
	}

	// get doctor Id
	public final String GetDoctotrId(String userId) {
		WebTarget service = client.target(DoctorIP).path("doctor").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			return null;
		}
	}

	// Get Appointments for a given doctor ID
	public final String GetAppointmentId(String userId) {
		WebTarget service = client.target(AppointmentIP).path("appoiment").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			return null;
		}
	}

	// Get Lab Appointments for a given laboratory ID
	public final String GetLabAppointmentId(String userId) {
		WebTarget service = client.target(AppointmentIP).path("appoiment").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			return null;
		}
	}

	// Get Hospital Appointments for a given Hospital ID
	public final String GetHospitalAppointmentId(String userId) {
		WebTarget service = client.target(AppointmentIP).path("appoiment").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			return null;
		}
	}

	// Get Appointments for a payment
	public final String GetPaymentsId(String userId) {
		WebTarget service = client.target(AppointmentIP).path("appoiment").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			return null;
		}
	}
	
	// Get Doctor for an Appointment
		public final String GetDocAppointmentId(String userId) {
			WebTarget service = client.target(DoctorIP).path("doctor").queryParam("id", userId);
			try {
				String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
				return response;
			} catch (ProcessingException e) {
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
				return null;
			}
		}

}
