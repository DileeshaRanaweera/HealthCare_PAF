package com.healthcare.gatewayUser.Auth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.UserDetails;
/**
 * @author kusal
 *
 */
public interface UserAuthInterface {

	public Response getUserSpecData();
	public Response postUser(UserDetails details);
	
}
