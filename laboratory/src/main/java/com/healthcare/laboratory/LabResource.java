/**
 * 
 */
package com.healthcare.laboratory;

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


/**
 * @author oshadi
 *
 */
@Path("labs")
public class LabResource {
	
	LabRepository repo = new LabRepository();

	//Insert
	@POST
	@Path("lab")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Lab createLab(Lab lab) {
		repo.create(lab);
		System.out.println(lab);
		return lab;
	}
	
	//Retrieve
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Lab> getLabs() {
		return repo.getLabs();
	}
	
	//Retrieve specific details
	@GET
	@Path("lab/{labRegID}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Lab getLab(@PathParam("labRegID") String labRegID) {
		return repo.getLab(labRegID);
	}
	
	//Update
	@PUT
	@Path("lab")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Lab updateLab(Lab l) {
		repo.update(l);
		System.out.println(l);
		return l;
	}
	

	//Update
		@PUT
		@Path("labReset")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Lab Reset(Lab l) {
			repo.reset(l);
			System.out.println(l);
			return l;
		}
		
	
	
	//Delete
	@DELETE
	@Path("lab/{labRegID}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Lab deleteLab(@PathParam("labRegID") String labRegID) {
		Lab l = repo.getLab(labRegID);

		if (l.getLabRegID() != null) {
			repo.deleteLab(labRegID);

		}
		return l;
	}

}
