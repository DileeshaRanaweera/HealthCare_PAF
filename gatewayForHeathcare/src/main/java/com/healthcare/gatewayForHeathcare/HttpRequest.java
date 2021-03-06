package com.healthcare.gatewayForHeathcare;

import java.io.IOException;

import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequest {

	IpDetails ipDetails;

	public HttpRequest() {

		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		ipDetails = ipDetailsClass.getIpDetails();
	}

	private final OkHttpClient okHttpClient = new OkHttpClient();

	public String GetDocSpecdata() throws Exception {
		Request request = new Request.Builder().url(ipDetails.getDocIP())

				// request headers
				.addHeader("key-PAF", "Healthcare").addHeader("Doctor-Profile", "Ramishka").build();

		try (Response response = okHttpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String responseData = response.body().string();
			return responseData;

		}

	}
	
	public String GetUserSpecdata() throws Exception {
		Request request = new Request.Builder().url(ipDetails.getUserIP())

				// request headers
				.addHeader("key-PAF", "Healthcare").addHeader("User-Profile", "Kusal").build();

		try (Response response = okHttpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String responseData = response.body().string();
			return responseData;

		}

	}
	
	public String GetLabSpecdata() throws Exception {
		Request request = new Request.Builder().url(ipDetails.getLabIP())

				// request headers
				.addHeader("key-PAF", "Healthcare").addHeader("Lab-Profile", "Oshadi").build();

		try (Response response = okHttpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String responseData = response.body().string();
			return responseData;

		}

	}
	
	public String GetHospitalSpecdata() throws Exception {
		Request request = new Request.Builder().url(ipDetails.getHospitalIP())

				// request headers
				.addHeader("key-PAF", "Healthcare").addHeader("Hospital-Profile", "Rashmika").build();

		try (Response response = okHttpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String responseData = response.body().string();
			return responseData;

		}

	}
	
	
	public String GetPaymentsSpecdata() throws Exception {
		Request request = new Request.Builder().url(ipDetails.getPaymentIP())

				// request headers
				.addHeader("key-PAF", "Healthcare").addHeader("Payments-Profile", "Chanuka").build();

		try (Response response = okHttpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String responseData = response.body().string();
			return responseData;

		}

	}
	
	public String GetAppointmentSpecdata() throws Exception {
		Request request = new Request.Builder().url(ipDetails.getAppoimentIP())

				// request headers
				.addHeader("key-PAF", "Healthcare").addHeader("Appointments-Profile", "Dileesha").build();

		try (Response response = okHttpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String responseData = response.body().string();
			return responseData;

		}

	}

}
