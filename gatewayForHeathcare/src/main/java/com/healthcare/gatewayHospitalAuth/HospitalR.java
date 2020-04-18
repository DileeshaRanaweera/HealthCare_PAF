/**
 * 
 */
package com.healthcare.gatewayHospitalAuth;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.HospitalDetails;
import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;

/**
 * @author user
 *
 */
public class HospitalR {

	String API;
	Client client = ClientBuilder.newClient();
	
	
	public HospitalR() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getHospitalIP();
	}
	
	public final Response getHospitalSpecData() {
		WebTarget service = client.target(API).path("hospital");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	public final Response postHospitalDetails(HospitalDetails hospitalDetails) {
		WebTarget service = client.target(API).path("hospital").path("add");
		try {
			Response response = service.request().post(Entity.json(hospitalDetails));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
