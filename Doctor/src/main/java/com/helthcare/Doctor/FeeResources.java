package com.helthcare.Doctor;

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

@Path("fees")
public class FeeResources {

	DoctorRepo repo = new DoctorRepo();

	// all doctors fee
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Fee> getdoctorfee() {

		return repo.getdoctorsfee();

	}

	//// specific doctor fee
	@GET
	@Path("fee/{nic}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Fee getdoctorfee(@PathParam("nic") String NIC) {

		return repo.getdDoctorfee(NIC);
	}

	//// specific doctor fee insert
	@POST
	@Path("fee")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Fee createDoctorfee(Fee fee) {

		repo.createDocfee(fee);
		return fee;
	}

	//// specific fee update
	@PUT
	@Path("fee")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Fee update(Fee F) {

		repo.updateDocfee(F);

		return F;
	}

	//// specific fee delete

	@DELETE
	@Path("fee/{nic}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Fee delete(@PathParam("nic") String NIC) {// specific id
		Doctor a = repo.getdDoctor(NIC);

		if (a.getNIC() != null) {
			repo.deletefee(NIC);
		}
		return repo.getdDoctorfee(NIC);
	}

}
