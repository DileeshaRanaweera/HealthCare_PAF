package com.healthcare.gatewayPaymentsAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.PaymentsDetails;

public class PaymentsAuthAppointment implements PaymentsAuth{

	PaymentsC paymentsC = new PaymentsC();
	@Override
	public Response getPaymentsSpecData() {
		// TODO Auto-generated method stub
		return paymentsC.getPaymentsSpecData();
	}

	@Override
	public Response postPayments(PaymentsDetails details) {
		// TODO Auto-generated method stub
		return paymentsC.postPaymentsDetails(details);
	}

}
