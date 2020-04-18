/**
 * 
 */
package com.healthcare.gatewayLabAuth;

import javax.ws.rs.core.Response;

import com.healthcare.gatewayDeatils.LabDetails;

/**
 * @author oshadi
 *
 */
public class LabAuthAppointment implements LabAuth {

	LabR labR = new LabR();
	
	@Override
	public Response getLabSpecData() {
		// TODO Auto-generated method stub
		return labR.getLabSpecData();
	}

	@Override
	public Response postLab(LabDetails labDetails) {
		// TODO Auto-generated method stub
		return labR.postLabDetails(labDetails);
	}

}
