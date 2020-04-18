package com.healthcare.gatewayDoctor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.healthcare.gatewayAuth.AuthFilter;
import com.healthcare.gatewayDeatils.DoctorDetails;
import com.healthcare.gatewayDoctorAuth.DoctorAuth;
import com.healthcare.gatewayDoctorAuth.DoctorAuthAppointment;
import com.healthcare.gatewayDoctorAuth.DoctorAuthDefult;
import com.healthcare.gatewayDoctorAuth.DoctorAuthDoctor;
import com.healthcare.gatewayDoctorAuth.DoctorAuthPAyment;
import com.healthcare.gatewayDoctorAuth.DoctorAuthUser;
/**
 * @author dyasa
 *
 */
@Path("doctorprof")
public class DoctorService {

	String currentUser;
	DoctorAuth doctorService;

	private void setInterfaces() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "appoinment":
			doctorService = new DoctorAuthAppointment();
			break;
		case "doctor":
			doctorService = new DoctorAuthDoctor();
			break;
		case "user":
			doctorService = new DoctorAuthUser();
			break;
		case "payment":
			doctorService = new DoctorAuthPAyment();
			break;
		case "hospital":
			doctorService = new DoctorAuthPAyment();
			break;
		default:
			doctorService = new DoctorAuthDefult();
			break;
		}

	}

	@GET
	public Response getDoctorSpecData() {
		setInterfaces();
		System.out.println(currentUser);
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		return doctorService.getDocSpecData();
	}

	@POST
	@Path("add")
	public Response postDoc(DoctorDetails doctorDetails) {
		setInterfaces();
		return doctorService.postDoc(doctorDetails);
	}

}
