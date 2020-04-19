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

@Path("appointsDoc")

public class AppointmentDocResource {
	
	AppointmentDocRepository repo = new AppointmentDocRepository(); 
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<AppointmentDoc> getDocAppointments(){
		
		System.out.println("getDoc Appointment called....");
		return repo.getDocAppointments();
	}
	
	
	
	
	@GET
	@Path("appointDoc/{appDocId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AppointmentDoc getDocAppointment(@PathParam("appDocId")int appDocId) {
		
		return repo.getDocAppointment(appDocId);
	}
	
	
	@POST
	@Path("createAppointDoc")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AppointmentDoc createDocAppointment(AppointmentDoc appDoc1) {
		
		System.out.println(appDoc1);
		repo.createDocAppointment(appDoc1);
		
		return appDoc1;
	}
	
	
	@PUT
	@Path("updateAppointDoc")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AppointmentDoc updateDocAppointment(AppointmentDoc appDoc1) {
		
		System.out.println(appDoc1);
		
		if(repo.getDocAppointment(appDoc1.getAppDocId()).getAppDocId()==0) {
			
			repo.createDocAppointment(appDoc1);
			
		}else {
			
			repo.updateDocAppointment(appDoc1);
		}
		
		
		return appDoc1;
	}
	
	
	
	@DELETE
	@Path("deleteAppointDoc/{appDocId}")
	public AppointmentDoc deleteDocAppointment(@PathParam("appDocId")int appDocId) {
		
		AppointmentDoc appDocDel = repo.getDocAppointment(appDocId);
		
		if(appDocDel.getAppDocId()!=0) {
			
			repo.deleteDocAppointment(appDocId);
		}
		return repo.getDocAppointment(appDocId);
		
	}
	

}
