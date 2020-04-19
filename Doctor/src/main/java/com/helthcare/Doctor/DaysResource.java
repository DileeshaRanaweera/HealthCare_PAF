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

@Path("days")
public class DaysResource {

	DoctorRepo repo = new DoctorRepo();

//all doctors	days
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Days> getdoctordays() {

		return repo.getdoctorsDays();

	}

////specific doctor days
	@GET
	@Path("day/{nic}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Days getdoctordays(@PathParam("nic") String NIC) {

		return repo.getdDoctordays(NIC);
	}

////specific doctor days insert
	@POST
	@Path("day")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Days createDoctorDays(Days doctorday) {

		repo.createDocdays(doctorday);
		return doctorday;
	}

////specific doctor update
	@PUT
	@Path("day")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Days update(Days D) {

		repo.updateDocdays(D);

		return D;
	}

////specific doctor delete

	@DELETE
	@Path("day/{nic}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Doctor delete(@PathParam("nic") String NIC) {// specific id
		Doctor a = repo.getdDoctor(NIC);

		if (a.getNIC() != null) {
			repo.deletedays(NIC);
		}
		return repo.getdDoctor(NIC);
	}

}
