/**
 * 
 */
package com.healthcare.gatewayHospitalAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.HospitalDetails;


/**
 * @author user
 *
 */
public interface HospitalAuth {
	
	public Response getHospitalSpecData();
	public Response postHospital(HospitalDetails hospitalDetails);

}
