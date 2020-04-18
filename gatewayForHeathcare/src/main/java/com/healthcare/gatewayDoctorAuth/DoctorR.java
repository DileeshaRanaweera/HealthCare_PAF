package com.healthcare.gatewayDoctorAuth;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.DoctorDetails;
import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;

public class DoctorR {

	String API;
	Client client = ClientBuilder.newClient();

	public DoctorR() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getDocIP();
	}
	
	public final Response getDoctorSpecData() {
		WebTarget service = client.target(API).path("doc");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	public final Response postDoctorDetails(DoctorDetails doctorDetails) {
		WebTarget service = client.target(API).path("doc").path("add");
		try {
			Response response = service.request().post(Entity.json(doctorDetails));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
