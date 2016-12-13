/**
 * 
 */
package com.app.work;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author deepakkumar
 *
 */
public class HttpUtil {
	
	public String  createRequest(List<NameValuePair> params, String uri){
		StringBuilder sb = new StringBuilder(uri);
		sb.append("?");

		for(NameValuePair param : params){
			sb.append(param.getName()+ "=" + param.getValue() + "&");
		}
		return sb.toString().substring(0, sb.toString().lastIndexOf("&"));

	}
	
	public String get(String uri){
		HttpGet httpGet;
		HttpClient client;
		HttpResponse response = null;
		try {
			httpGet = new HttpGet(uri);
			client = HttpClients.createDefault();
			//httpGet.addHeader("User-Agent", USER_AGENT);
			response = client.execute(httpGet);
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println(responseBody);
			return responseBody;
		}catch (Exception ex){
			System.out.println(ex);
		}
		return null;
	}

}
