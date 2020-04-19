package com.PAFProject.HeathCare;

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



@Path("appointsLab")
public class AppointmentLabResource {
	
AppointmentLabRepository repo = new AppointmentLabRepository(); 
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<AppointmentLab> getLabAppointments(){
		
		System.out.println("getLab Appointment called....");
		return repo.getLabAppointments();
	}
	
	
	
	
	@GET
	@Path("appointLab/{appLabId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AppointmentLab getLabAppointment(@PathParam("appLabId")int appLabId) {
		
		return repo.getLabAppointment(appLabId);
	}
	
	
	@POST
	@Path("createAppointLab")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AppointmentLab createLabAppointment(AppointmentLab appLab1) {
		
		System.out.println(appLab1);
		repo.createLabAppointment(appLab1);
		
		return appLab1;
	}
	
	
	@PUT
	@Path("updateAppointLab")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AppointmentLab updateLabAppointment(AppointmentLab appLab1) {
		
		System.out.println(appLab1);
		
		if(repo.getLabAppointment(appLab1.getAppLabId()).getAppLabId()==0) {
			
			repo.createLabAppointment(appLab1);
			
		}else {
			
			repo.updateLabAppointment(appLab1);
		}
		
		
		return appLab1;
	}
	
	
	
	@DELETE
	@Path("deleteAppointLab/{appLabId}")
	public AppointmentLab deleteLabAppointment(@PathParam("appLabId")int appLabId) {
		
		AppointmentLab appLabDel = repo.getLabAppointment(appLabId);
		
		if(appLabDel.getAppLabId()!=0) {
			
			repo.deleteLabAppointment(appLabId);
		}
		return repo.getLabAppointment(appLabId);
		
	}
	

}
