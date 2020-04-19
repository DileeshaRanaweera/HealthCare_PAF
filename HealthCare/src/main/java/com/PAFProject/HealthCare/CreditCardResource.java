package com.PAFProject.HealthCare;

import java.util.Arrays;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("creditdetails")
public class CreditCardResource {
	
	CreditCardRepo repo = new CreditCardRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CreditCard> getCreditDetails() {
		
		return repo.getCreditDetails();
	}
	
	@GET
	@Path("owner/{CardNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard getCreditCard(@PathParam("CardNo") int CardNo) {
		
		return repo.getCreditCard(CardNo);
		
	}
	
	@POST
	@Path("createdetails")
	@Consumes(MediaType.APPLICATION_JSON)
	public CreditCard createDetails(CreditCard c) {
		repo.createDetails(c);
		return c;
	}
	

}
