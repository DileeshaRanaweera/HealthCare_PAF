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
public interface LabAuth {
	
	public Response getLabSpecData();
	public Response postLab(LabDetails labDetails);

}
