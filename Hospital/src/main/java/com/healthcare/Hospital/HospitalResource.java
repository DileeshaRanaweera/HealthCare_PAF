/**
 * 
 */
package com.healthcare.Hospital;

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
 * @author user
 *
 */
@Path("hospitals")
public class HospitalResource {
	
HospitalRepository repo = new HospitalRepository();
	
	
	//Insert
		@POST
		@Path("hospital")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Hospital createHospital(Hospital hospital) {
			repo.create(hospital);
			System.out.println(hospital);
			return hospital;
		}
		
		
		//Retrieve
		@GET
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public List<Hospital> getHospital() {
			return repo.getHospitals();
		}
		
		//Retrieve specific details
		@GET
		@Path("hospital/{HRegID}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Hospital getLab(@PathParam("HRegID") String HRegID) {
			return repo.getHospital(HRegID);
		}
		
		//Update
		@PUT
		@Path("hospital")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Hospital updateHospital(Hospital h) {
			repo.update(h);
			System.out.println(h);
			return h;
		}
		
		
		//Update
				@PUT
				@Path("hospitalReset")
				@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
				public Hospital Reset(Hospital h) {
					repo.reset(h);
					System.out.println(h);
					return h;
				}
				
			
		

		//Delete
		@DELETE
		@Path("hospital/{HRegID}")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Hospital deleteHospital(@PathParam("HRegID") String HRegID) {
			Hospital h = repo.getHospital(HRegID);

			if (h.getHRegID() != null) {
				repo.deleteHospital(HRegID);

			}
			return h;
		}


}
