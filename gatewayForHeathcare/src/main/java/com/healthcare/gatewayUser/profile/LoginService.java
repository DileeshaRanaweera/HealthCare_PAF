package com.healthcare.gatewayUser.profile;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.healthcare.gatewayAuth.AuthFilter;

public class LoginService {

	LoginClient loginClient = new LoginClient();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTokenString(@QueryParam("user") String username, @QueryParam("pwd") String password) {
		System.out.println(AuthFilter.CurrentAuth);
		try {
			return loginClient.loginTokenApiCaller(username, password);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
