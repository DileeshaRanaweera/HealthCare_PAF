package com.healthcare.gatewayUser.Auth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.UserDetails;
/**
 * @author kusal
 *
 */
public class UserAuthDoctor implements UserAuthInterface {

	UserClient userClient = new UserClient();

	@Override
	public Response getUserSpecData() {
		// TODO Auto-generated method stub
		return userClient.getUserSpecData();
	}

	@Override
	public Response postUser(UserDetails details) {
		// TODO Auto-generated method stub
		return userClient.postUser(details);
	}

}
