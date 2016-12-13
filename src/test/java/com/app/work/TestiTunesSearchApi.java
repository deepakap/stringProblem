package com.app.work;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestiTunesSearchApi extends HttpUtil {

	static final String GET_ITUNES_SEARCH = "https://itunes.apple.com/search";
	List<NameValuePair> params;

	@BeforeMethod
	public void defineSearchParams() {
		params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("format", "json"));
		params.add(new BasicNameValuePair("term", "jack+johnson"));
	}

	@Test(enabled = true)
	public void _testSearchTerm() {
		String uri = createRequest(params, GET_ITUNES_SEARCH);
		System.out.println(uri);
		String response = get(uri);
		JSONObject object = new JSONObject(response);
		JSONArray resultArray = object.getJSONArray("results");
		for (int i = 0; i < resultArray.length(); i++) {
			Assert.assertTrue(resultArray.getJSONObject(i)
					.getString("artistName").contains("Jack"));
		}

	}

	@Test
	public void _testSearchTermCountry() {
		params.add(new BasicNameValuePair("country", "US"));
		String uri = createRequest(params, GET_ITUNES_SEARCH);
		System.out.println(uri);
		String response = get(uri);
		JSONObject object = new JSONObject(response);
		JSONArray resultArray = object.getJSONArray("results");
		for (int i = 0; i < resultArray.length(); i++) {
			Assert.assertTrue(resultArray.getJSONObject(i).getString("country")
					.contains("USA"));
		}
	}

	@Test
	public void _testSearchTermCountryMedia() {
		params.add(new BasicNameValuePair("country", "US"));
		params.add(new BasicNameValuePair("media", "software"));
		String uri = createRequest(params, GET_ITUNES_SEARCH);
		System.out.println(uri);
		String response = get(uri);
		JSONObject object = new JSONObject(response);
		JSONArray resultArray = object.getJSONArray("results");
		for (int i = 0; i < resultArray.length(); i++) {
			Assert.assertTrue(resultArray.getJSONObject(i).getString("kind")
					.contains("software"));
		}
	}

	@Test
	public void _testSearchTermCountryMediaWithLimit() {
		params.add(new BasicNameValuePair("country", "US"));
		params.add(new BasicNameValuePair("media", "all"));
		params.add(new BasicNameValuePair("limit", "10"));
		get(createRequest(params, GET_ITUNES_SEARCH));
	}

}
