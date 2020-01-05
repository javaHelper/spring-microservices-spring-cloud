package com.prateek;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableOAuth2Sso
public class ReportController{

	private static final String TOLL_DATA_URI = "http://localhost:9001/services/tolldata";

	@Autowired
    private OAuth2ClientContext clientContext;
	
	@Autowired
    private OAuth2RestTemplate oauth2RestTemplate;
	
	@GetMapping("/")
	public String loadHome(){
		return "home";
	}
	
	@GetMapping("/reports")
	public String loadReports(Model model){
		
		OAuth2AccessToken t = clientContext.getAccessToken();
		System.out.println("Token: " + t.getValue());
		
//		TollUsage instance1 = new TollUsage("100", "station50", "B65GT1W", "2016-09-30T06:31:22");
//		TollUsage instance2 = new TollUsage("101", "station19", "AHY673B", "2016-09-30T06:32:50");
//		TollUsage instance3 = new TollUsage("102", "station50", "ZN2GP0", "2016-09-30T06:37:01");
//		
//		ArrayList<TollUsage> tolls = new ArrayList<>();
//		tolls.add(instance1);
//		tolls.add(instance2);
//		tolls.add(instance3);
		
		ResponseEntity<ArrayList<TollUsage>> tolls = oauth2RestTemplate.exchange(TOLL_DATA_URI, HttpMethod.GET, 
				null, new ParameterizedTypeReference<ArrayList<TollUsage>>(){});

		model.addAttribute("tolls", tolls.getBody());

		return "reports";
	}
}
