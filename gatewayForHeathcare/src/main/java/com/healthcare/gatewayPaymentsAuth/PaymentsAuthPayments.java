package com.healthcare.gatewayPaymentsAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.PaymentsDetails;

public class PaymentsAuthPayments implements PaymentsAuth {
	
	PaymentsC paymentsC = new PaymentsC();

	@Override
	public Response getPaymentsSpecData() {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

	@Override
	public Response postPayments(PaymentsDetails details) {
		// TODO Auto-generated method stub
		return paymentsC.postPaymentsDetails(details);
	}

}
