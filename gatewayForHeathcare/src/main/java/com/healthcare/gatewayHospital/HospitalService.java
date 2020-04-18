/**
 * 
 */
package com.healthcare.gatewayHospital;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayAuth.AuthFilter;
import com.healthcare.gatewayDeatils.HospitalDetails;
import com.healthcare.gatewayHospitalAuth.HospitalAuth;
import com.healthcare.gatewayHospitalAuth.HospitalAuthAppointment;
import com.healthcare.gatewayHospitalAuth.HospitalAuthDefault;
import com.healthcare.gatewayHospitalAuth.HospitalAuthDoctor;
import com.healthcare.gatewayHospitalAuth.HospitalAuthHospital;
import com.healthcare.gatewayHospitalAuth.HospitalAuthPayment;

/**
 * @author user
 *
 */
@Path("hospitalprof")
public class HospitalService {
	
	String currentUser;
	HospitalAuth hospitalService;
	
	private void setInterfaces() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "appoinment":
			hospitalService = new HospitalAuthAppointment();
			break;
		case "hospital":
			hospitalService = new HospitalAuthHospital();
			break;
		case "doctor":
			hospitalService = new HospitalAuthDoctor();
			break;
		case "payment":
			hospitalService = new HospitalAuthPayment();
			break;
		default:
			hospitalService = new HospitalAuthDefault();
			break;
		}

	}

	@GET
	public Response getHospitalSpecData() {
		setInterfaces();
		System.out.println(currentUser);
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		return hospitalService.getHospitalSpecData();
	}

	@POST
	@Path("add")
	public Response postHospital(HospitalDetails hospitalDetails) {
		setInterfaces();
		return hospitalService.postHospital(hospitalDetails);
	}


}
