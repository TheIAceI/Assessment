package com.tds.assessment.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class CountrySingleton {

	/**
	 * Description: This Sinlgeton class calls an external API that returns all
	 * country codes and names. Stores the data in a JSONObject.
	 **/

	private static final String COUNTRYAPI = "https://restcountries.eu/rest/v2/all";

	public Boolean started = false;

	JSONObject jsonCountryAlpha3 = new JSONObject();
	JSONObject jsonCountryAlpha2 = new JSONObject();

	private static CountrySingleton single_instance = null;

	private CountrySingleton() {
	}

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
	}
	
	//Return the country name by the code Alpha2 or Alpha3. Ex IE or IRL for Ireland
	public String getCoutryName(String code) {
		String countryName = code;
		if (code.length() == 3) {
			countryName = jsonCountryAlpha3.getString(code);
		} else if (code.length() == 2) {
			countryName = jsonCountryAlpha2.getString(code);
		}
		if (countryName == null) {
			return code;
		}
		return countryName;
	}

	//Sends a Get Request to the Rest Countries API. Returns all the countries.
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
