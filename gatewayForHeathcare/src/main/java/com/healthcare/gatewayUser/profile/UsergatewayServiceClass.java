package com.healthcare.gatewayUser.profile;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("api/user")
public class UsergatewayServiceClass {

	UserHttpRequest userHttpRequest = new UserHttpRequest();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDocSpecification(@QueryParam("user") String username, 
			@QueryParam("pwd") String password) { 
    	 try {
    		
			return userHttpRequest.GetSpeofUsercdata(username,password);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
	
	@POST
	@Path("test")
	public String token(String x) {
		return userHttpRequest.tokenString(x);
	}
	
}
