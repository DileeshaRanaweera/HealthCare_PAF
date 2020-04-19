package com.PAFProject.HealthCare;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("payments")
public class PaymentResource {
	
	PaymentRepo repo = new PaymentRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payments> getAllPayments(){
		return repo.getAllPayments();
		
	}
	
	@GET
	@Path("payment/{PaymentID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payments getPayment(@PathParam("PaymentID") int PaymentID) {
		
		return repo.getPayment(PaymentID);
		
	}
	
	@POST
	@Path("createpayment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payments createPayment(Payments p) {
		repo.createPayments(p);
		return p;
	}
	
	@PUT
	@Path("updatepayment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payments updatePayment(Payments p) {
		repo.updatePayments(p);
		return p;
	}
	
	@DELETE
	@Path("deletepayment/{PaymentID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payments deletePayment(@PathParam("PaymentID") int PaymentID) {
		
		Payments p = repo.getPayment(PaymentID);
		
		if(p.getPaymentID()!=0)
			repo.deletePayments(PaymentID);
		return p;
		
	}
	
	
}
