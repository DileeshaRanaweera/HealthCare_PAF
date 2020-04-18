package com.healthcare.gatewayUser.profile;

import java.io.IOException;

import com.healthcare.gatewayDeatils.IpDetails;
import com.healthcare.gatewayDeatils.IpDetailsClass;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/**
 * @author kusal
 *
 */
public class UserHttpRequest {

	IpDetails ipDetails;
	private final OkHttpClient httpClient = new OkHttpClient();
	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

	public UserHttpRequest() {
		super();
		IpDetailsClass ipDetailsClass = new IpDetailsClass();
		ipDetails = ipDetailsClass.getIpDetails();
	}

	public String GetSpeofUsercdata(String username, String password) throws Exception {
		Request request = new Request.Builder().url(ipDetails.getUserIP() + "/" + username + "/" + password)
				.addHeader("key-PAF", "Healthcare") // add request headers
				.addHeader("User-Profile", "Kusal").build();

		try (Response response = httpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);
			String responseData = response.body().string();
			return responseData;
		}

	}
	
	public String tokenString(String x) {
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(JSON, x);
		Request request = new Request.Builder()
                .url(ipDetails.getUserIP()+"/login/webapi/login/usertoken")
                .addHeader("custom-key", "PAF")  // add request headers
                .addHeader("User-Agent", "Nayanajith")
                .post(body)
                .build();
		try (Response response = httpClient.newCall(request).execute()) {
			return response.body().string();
            //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        } catch (IOException e) {
			e.printStackTrace();
		}
		return x;
	}

}
