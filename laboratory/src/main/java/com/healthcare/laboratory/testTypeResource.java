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
@Path("types")
public class testTypeResource {

	testTypeRepository repo = new testTypeRepository();
	
	
	//Insert
	@POST
	@Path("type")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public testType createType(testType type) {
		repo.create(type);
		System.out.println(type);
		return type;
		
	}
	
	
	//Retrieve
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<testType> getTypes() {
		return repo.getTypes();
	}
	
	//Retrieve specific details
	@Path("type/{labRegID}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public testType getType(@PathParam("labRegID") String labRegID) {
		return repo.getType(labRegID);
	}
	
	
	//Update
		@PUT
		@Path("type")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public testType updateType(testType type) {
			repo.updateType(type);
			System.out.println(type);
			return type;
		}
		
			
		
		
		//Delete
		@DELETE
		@Path("type/{labRegID}")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public testType deleteType(@PathParam("labRegID") String labRegID) {
			testType type = repo.getType(labRegID);

			if (type.getLabRegID() != null) {
				repo.deleteType(labRegID);

			}
			return type;
		}
	
}
