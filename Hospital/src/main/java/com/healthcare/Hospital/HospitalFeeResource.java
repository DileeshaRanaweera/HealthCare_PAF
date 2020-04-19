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
 * @author Rashmika
 *
 */
@Path("hospitalFees")
public class HospitalFeeResource {
	
	HospitalFeeRepository repo = new HospitalFeeRepository();

	// Insert
	@POST
	@Path("hospitalFee")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HospitalFee createHospitalFee(HospitalFee fee) {
		repo.createFee(fee);
		System.out.println(fee);
		return fee;
	}

	// Retrieve
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<HospitalFee> getHospitalFees() {
		return repo.getHospitalFees();
	}

	// Retrieve specific details
	@GET
	@Path("hospitalFee/{HFeeID}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HospitalFee getHospitalFee(@PathParam("HRegID") String HFeeID) {
		return repo.getHospitalFee(HFeeID);
	}

	// Update
	@PUT
	@Path("hospitalFee")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HospitalFee updateHospitalFeeDetails(HospitalFee fee) {
		repo.updateHospitalFeeDetails(fee);
		System.out.println(fee);
		return fee;
	}

	// Delete
	@DELETE
	@Path("hospitalFee/{HFeeID}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HospitalFee deleteHospitalFee(@PathParam("HFeeID") String HFeeID) {
		HospitalFee fee = repo.getHospitalFee(HFeeID);

		if (fee.getHRegID() != null) {
			repo.deleteHospitalFee(HFeeID);

		}
		return fee;
	}

}
