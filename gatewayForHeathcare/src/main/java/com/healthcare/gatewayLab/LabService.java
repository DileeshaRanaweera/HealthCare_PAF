/**
 * 
 */
package com.healthcare.gatewayLab;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayAuth.AuthFilter;
import com.healthcare.gatewayDeatils.LabDetails;
import com.healthcare.gatewayLabAuth.LabAuth;
import com.healthcare.gatewayLabAuth.LabAuthAppointment;
import com.healthcare.gatewayLabAuth.LabAuthDefault;
import com.healthcare.gatewayLabAuth.LabAuthLab;
import com.healthcare.gatewayLabAuth.LabAuthPayment;



/**
 * @author oshadi
 *
 */
@Path("labprof")
public class LabService {
	
	String currentUser;
	LabAuth labService;
	
	private void setInterfaces() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "appoinment":
			labService = new LabAuthAppointment();
			break;
		case "lab":
			labService = new LabAuthLab();
			break;
		case "payment":
			labService = new LabAuthPayment();
			break;
		default:
			labService = new LabAuthDefault();
			break;
		}

	}
	
	
	@GET
	public Response getUserSpecData() {
		setInterfaces();
		System.out.println(currentUser);
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		return labService.getLabSpecData();
	}

	@POST
	@Path("add")
	public Response postUser(LabDetails labDetails) {
		setInterfaces();
		return labService.postLab(labDetails);
	}


}
