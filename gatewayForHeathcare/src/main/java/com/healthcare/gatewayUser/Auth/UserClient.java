package com.healthcare.gatewayUser.Auth;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;
import com.healthcare.gatewayDeatils.UserDetails;
/**
 * @author kusal
 *
 */
public class UserClient {

	String API;
	Client client = ClientBuilder.newClient();

	public UserClient() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getUserIP();
	}

	public final Response getUserSpecData() {
		WebTarget service = client.target(API).path("user");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	public final Response postUser(UserDetails details) {
		WebTarget service = client.target(API).path("user").path("add");
		try {
			Response response = service.request().post(Entity.json(details));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
