package com.healthcare.gatewayAuth;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import com.gateway.message.Message;
import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;

@Provider
public class AuthFilter implements ContainerRequestFilter {

	private static final String REALM = "example";
	private static final String AUTHENTICATION_SCHEME = "Bearer ";

	private String[] urlSkipper = new String[3];
	AuthClient client = new AuthClient();
	public static String CurrentAuth = "defult";
	public static String CurrentAuthUserId = "0";
	public static String CurrentAuthUserDoctorId = "0";
	public static String CurrentAuthUserAppointmentId = "0";
	public static String CurrentAuthUserLabAppointmentId = "0";
	public static String CurrentAuthUserHospitalAppointmentId = "0";
	public static String CurrentAuthUserPaymentsAppointmentId = "0";

	@Context
	private UriInfo info;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		UriInfo info = requestContext.getUriInfo();
		// System.out.println("Headers " + requestContext.getHeaders());

		String reqPath = info.getAbsolutePath().toString().trim();

		Init();

		if (urlSkipper[0].equals(reqPath)) {
			return;
		}

		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader == null) {
			abortWithUnauthorized(requestContext, Message.addToken);
		} else {
			String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

			System.out.println(token);
			this.authChecker(token, requestContext);
		}
	}

	private void authChecker(String tokenString, ContainerRequestContext requestContext) {

		String mode = client.AuthChecker(tokenString);
		mode = mode.trim();

		String[] arr = mode.split(",");

		if (!arr[0].equals("false")) {
			CurrentAuth = arr[0];
			CurrentAuthUserId = arr[1];
			CurrentAuthUserDoctorId = this.getDoctorID(arr[1]);
			//check this for user appointments for a given Doctor ID
			CurrentAuthUserAppointmentId = this.getAppointmentID(arr[1]);
			//check this for lab appointments
			CurrentAuthUserLabAppointmentId = this.getLabAppointmentID(arr[1]);
			//check this for hospital appointments
			CurrentAuthUserHospitalAppointmentId = this.getHospitalAppointmentID(arr[1]);
			//check this for payment appointments
			CurrentAuthUserPaymentsAppointmentId = this.getPaymentsAppointmentID(arr[1]);
			
			
			return;
		} else {
			abortWithUnauthorized(requestContext, Message.Unauthorize);
		}

	}

	private void abortWithUnauthorized(ContainerRequestContext requestContext, String message) {

		// Abort the filter chain with a 401 status code response
		// The WWW-Authenticate header is sent along with the response
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
				.entity(message).build());
	}

	private void Init() {
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		IpDetails iMapperDTO = ipDetailsClass.getIpDetails();
		urlSkipper[0] = iMapperDTO.getGatewayIP() + Message.path("login");

	}

	// user part doctor
	private String getDoctorID(String UserID) {
		String result[] = client.GetDoctotrId(UserID).split(",");
		return result[0];

	}
	
	private String getAppointmentID(String UserID) {
		String result[] = client.GetAppointmentId(UserID).split(",");
		return result[0];

	}
	
	private String getLabAppointmentID(String UserID) {
		String result[] = client.GetLabAppointmentId(UserID).split(",");
		return result[0];

	}
	
	private String getHospitalAppointmentID(String UserID) {
		String result[] = client.GetHospitalAppointmentId(UserID).split(",");
		return result[0];

	}
	
	private String getPaymentsAppointmentID(String UserID) {
		String result[] = client.GetPaymentsId(UserID).split(",");
		return result[0];

	}
}
