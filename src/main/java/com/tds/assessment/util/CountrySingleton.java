package com.tds.assessment.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class CountrySingleton {

	private static final String COUNTRYAPI = "https://restcountries.eu/rest/v2/all";

	public Boolean started = false;

	JSONObject jsonCountryAlpha3 = new JSONObject();
	JSONObject jsonCountryAlpha2 = new JSONObject();

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
	
	public void setCountryListAlpha2() throws Exception {
		String countryList = sendGetRequest();
		if (!countryList.equals("")) {
			JSONArray ja = new JSONArray(countryList.trim());
			for (int i = 0; i < ja.length(); i++) {
				JSONObject objectInArray = ja.getJSONObject(i);
				jsonCountryAlpha2.put(objectInArray.get("alpha2Code").toString(), objectInArray.get("name").toString());
			}
		}
		System.out.println("2 "+jsonCountryAlpha2.toString());
	}

	public void setCountryListAlpha3() throws Exception {
		String countryList = sendGetRequest();
		if (!countryList.equals("")) {
			JSONArray ja = new JSONArray(countryList.trim());
			for (int i = 0; i < ja.length(); i++) {
				JSONObject objectInArray = ja.getJSONObject(i);
				jsonCountryAlpha3.put(objectInArray.get("alpha3Code").toString(), objectInArray.get("name").toString());
			}
		}
		System.out.println("3 "+jsonCountryAlpha3.toString());

	}
	
	public String getCoutryName(String code) {
		String countryName = code;
		
		if(code.length() == 3) {
			countryName = jsonCountryAlpha3.getString(code);
		} else if(code.length() == 2) {
			countryName = jsonCountryAlpha2.getString(code);
		}		
		
		if (countryName == null) {
			return code;
		}
		return countryName;
	}

	private String sendGetRequest() throws IOException {
		String inline = "";

		URL url = new URL(COUNTRYAPI);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if (responsecode != 200) {
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {

			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				inline += sc.nextLine();
			}
			sc.close();
		}
		return inline.toString();
	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

}
