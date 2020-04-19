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


@Path("doctors")
public class DoctorResources {
	
	DoctorRepo repo = new DoctorRepo();
	
	//all doctors	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Doctor> getdoctors() {
		
		return repo.getdoctors();
			
	}
	
//// specific doctor
	@GET
	@Path("doc/{nic}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor getdoctor(@PathParam("nic") String NIC) {
		
		return repo.getdDoctor(NIC);
	}
	
////specific doctor insert
	@POST
	@Path("doc")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor creDoctor(Doctor doctor) {
		
		
		repo.create(doctor);
		return doctor;
	}
	
	

////specific doctor update
	@PUT
	@Path("doc")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor update(Doctor D) {
	
			repo.update(D);
		
		return D;
	}
	

////specific doctor delete
	
	@DELETE
	@Path("doc/{nic}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor delete(@PathParam("nic") String NIC) {// specific id 
		Doctor a = repo.getdDoctor(NIC);
		
		if(a.getNIC() != null) {
			repo.delete(NIC);
		}
		return repo.getdDoctor(NIC);
	}

//////specific doctor uname pws update
	@PUT
	@Path("docreset")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor updateuname(Doctor D) {
	
			repo.updateuname(D);
		
		return D;
	}

}
