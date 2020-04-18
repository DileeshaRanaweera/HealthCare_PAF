/**
 * 
 */
package com.healthcare.gatewayLabAuth;

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
import com.healthcare.gatewayDeatils.LabDetails;

/**
 * @author oshadi
 *
 */
public class LabR {
	
	String API;
	Client client = ClientBuilder.newClient();
	
	public LabR() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getDocIP();
	}
	
	
	
	public final Response getLabSpecData() {
		WebTarget service = client.target(API).path("lab");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	public final Response postLabDetails(LabDetails labDetails) {
		WebTarget service = client.target(API).path("lab").path("add");
		try {
			Response response = service.request().post(Entity.json(labDetails));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
