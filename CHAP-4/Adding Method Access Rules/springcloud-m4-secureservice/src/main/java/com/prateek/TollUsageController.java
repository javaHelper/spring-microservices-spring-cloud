package com.prateek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TollUsageController {
	@Autowired
	private ResourceServerProperties sso;
	
	@Bean
	public ResourceServerTokenServices myUserInfoTokenServices() {
		return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
	}
	
	@GetMapping("/tolldata")
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	public List<TollUsage> getTollData() {
		TollUsage instance1 = new TollUsage("200", "station150", "B65GT1W", "2016-09-30T06:31:22");
		TollUsage instance2 = new TollUsage("201", "station119", "AHY673B", "2016-09-30T06:32:50");
		TollUsage instance3 = new TollUsage("202", "station150", "ZN2GP0", "2016-09-30T06:37:01");
		
		ArrayList<TollUsage> tolls = new ArrayList<>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);
		return tolls;
	}
}
