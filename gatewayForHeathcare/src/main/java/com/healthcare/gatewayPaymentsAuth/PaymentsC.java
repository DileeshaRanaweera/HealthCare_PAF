package com.healthcare.gatewayPaymentsAuth;

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
import com.healthcare.gatewayDeatils.PaymentsDetails;

public class PaymentsC {
	String API;
	Client client = ClientBuilder.newClient();

	public PaymentsC() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getPaymentIP();
	}
	
	public final Response getPaymentsSpecData() {
		WebTarget service = client.target(API).path("payment");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	public final Response postPaymentsDetails(PaymentsDetails paymentsDetails) {
		WebTarget service = client.target(API).path("payment").path("add");
		try {
			Response response = service.request().post(Entity.json(paymentsDetails));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
