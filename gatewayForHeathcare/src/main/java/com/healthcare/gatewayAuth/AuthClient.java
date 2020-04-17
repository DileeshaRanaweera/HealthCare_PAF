package com.healthcare.gatewayAuth;

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
	
	//get doctor Id
	public final String GetDoctotrId(String userId) {
		WebTarget service = client.target(DoctorIP).path("user").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			 Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			 return null;
		}
	}
	
	
}
