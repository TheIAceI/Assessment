package com.tds.assessment.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class CountrySingleton {

	private static final String COUNTRYAPI = "https://restcountries.eu/rest/v2/all";

	public Boolean started = false;

	JSONObject jsonCountry = new JSONObject();

	private static CountrySingleton single_instance = null;

	// private constructor restricted to this class itself
	private CountrySingleton() {
	}

	// static method to create instance of Singleton class
	public static CountrySingleton getInstance() {
		if (single_instance == null)
			single_instance = new CountrySingleton();

		return single_instance;
	}

	public void setCountryList() throws Exception {
		String countryList = sendGet();
		System.out.println("LLL: "+countryList);

		if (!countryList.equals("")) {
			JSONArray ja = new JSONArray(countryList.trim());
			for (int i = 0; i < ja.length(); i++) {				
				System.out.println(ja.get(i));
				JSONObject objectInArray = ja.getJSONObject(i);
				jsonCountry.put(objectInArray.get("alpha3Code").toString(), objectInArray.get("name").toString());
			}
		}

		//System.out.println(jsonCountry);
		jsonCountry = new JSONObject(countryList);
	}

	public String getCoutryName(String code) {
		String countryName = jsonCountry.getString(code);
		if (countryName == null) {
			return code;
		}
		return countryName;
	}

	private static String sendGet() throws Exception {
		URL obj = new URL(COUNTRYAPI);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		// System.out.println(response.toString());
		return response.toString();

	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

}
