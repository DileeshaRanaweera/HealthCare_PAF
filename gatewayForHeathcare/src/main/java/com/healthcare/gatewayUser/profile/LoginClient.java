package com.healthcare.gatewayUser.profile;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;
/**
 * @author kusal
 *
 */
public class LoginClient {

	String API;

	public LoginClient() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails ipDetails = ipDetailsClass.getIpDetails();
		API = ipDetails.getUserIP();
	}

	Client client = ClientBuilder.newClient();

	public final String loginTokenApiCaller(String username, String password) {
		System.out.println(username + password);
		WebTarget service = client.target(API).path(username).path(password);
		try {
			String response = service.request(MediaType.TEXT_PLAIN).get(String.class);
			return response;
		} catch (ProcessingException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return API;

	}

}
