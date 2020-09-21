package com.tds.assessment.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	
	/**
	 *  This is a slow approach.
	 *  The best approach would be get all countries at first in an object and get the object by name calling api once.
	 *  The problem is... If a country change name we must restart the application 
	 *  **/
	
	private static final String COUNTRYAPI = "https://restcountries.eu/rest/v2/alpha/";
		
	public String getCountryName(String code) throws Exception {
		JSONObject country = new JSONObject(sendGet(code));		
		return country.getString("name");
	}	
	
	private static String sendGet(String code) throws Exception {
		URL obj = new URL(COUNTRYAPI + code);
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

}
