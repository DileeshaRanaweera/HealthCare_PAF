package com.healthcare.gatewayPaymentsAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.PaymentsDetails;

public interface PaymentsAuth {
	
	public Response getPaymentsSpecData();
	public Response postPayments(PaymentsDetails details);

}
