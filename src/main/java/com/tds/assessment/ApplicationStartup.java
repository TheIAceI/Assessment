package com.tds.assessment;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.tds.assessment.util.CountrySingleton;

@Component
public class ApplicationStartup { 
	
	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */

	
	CountrySingleton countruSingleton = CountrySingleton.getInstance(); 
	
	@PostConstruct
    private void postConstruct() throws Exception {
		if(!countruSingleton.getStarted()) {
			countruSingleton.setCountryListAlpha2();
			countruSingleton.setCountryListAlpha3();		
		}		
		countruSingleton.setStarted(true);
	}

}