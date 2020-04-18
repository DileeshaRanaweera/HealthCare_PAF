package com.healthcare.gatewayForHeathcare;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ResoursePage {

	@Path("api")
	public class MyResource {

		HttpRequest mycall = new HttpRequest();

		@GET
		@Path("doc")
		@Produces(MediaType.APPLICATION_JSON)
		public String getDocSpecification() {
			try {

				return mycall.GetDocSpecdata();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		@GET
		@Path("user")
		@Produces(MediaType.APPLICATION_JSON)
		public String getUserSpecification() {
			try {

				return mycall.GetUserSpecdata();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		@GET
		@Path("lab")
		@Produces(MediaType.APPLICATION_JSON)
		public String getLabSpecification() {
			try {

				return mycall.GetLabSpecdata();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		@GET
		@Path("payments")
		@Produces(MediaType.APPLICATION_JSON)
		public String getPaymentsSpecification() {
			try {

				return mycall.GetPaymentsSpecdata();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
	}

}
