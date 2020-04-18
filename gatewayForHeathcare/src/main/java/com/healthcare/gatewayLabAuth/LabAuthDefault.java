/**
 * 
 */
package com.healthcare.gatewayLabAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.LabDetails;

/**
 * @author oshadi
 *
 */
public class LabAuthDefault implements LabAuth {

	@Override
	public Response getLabSpecData() {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();

	}

	@Override
	public Response postLab(LabDetails labDetails) {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

}
