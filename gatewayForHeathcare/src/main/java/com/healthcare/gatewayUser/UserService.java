package com.healthcare.gatewayUser;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayAuth.AuthFilter;
import com.healthcare.gatewayDeatils.UserDetails;
import com.healthcare.gatewayUser.Auth.UserAuthAppointment;
import com.healthcare.gatewayUser.Auth.UserAuthDefault;
import com.healthcare.gatewayUser.Auth.UserAuthDoctor;
import com.healthcare.gatewayUser.Auth.UserAuthInterface;
import com.healthcare.gatewayUser.Auth.UserAuthUser;

@Path("userprof")
public class UserService {

	String currentUser;
	UserAuthInterface userService;
	
	private void setInterfaces() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "appoinment":
			userService = new UserAuthAppointment();
			break;
		case "doctor":
			userService = new UserAuthDoctor();
			break;
		case "user":
			userService = new UserAuthUser();
			break;
		default:
			userService = new UserAuthDefault();
			break;
		}

	}
	
	@GET
	public Response getUserSpecData() {
		setInterfaces();
		System.out.println(currentUser);
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		return userService.getUserSpecData();
	}
	
	@POST
	@Path("add")
	public Response postUser(UserDetails details) {
		setInterfaces();
		return userService.postUser(details);
	}


}
