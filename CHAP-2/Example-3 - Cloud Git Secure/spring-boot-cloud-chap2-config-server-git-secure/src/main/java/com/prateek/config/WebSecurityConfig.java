package com.prateek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Below code is equivalent to security.basic.enabled=false if using Spring Boot 1.X version, 
 * However if you're using Spring Boot 2.x, add below @Bean
 * https://stackoverflow.com/questions/49717573/property-security-basic-enabled-is-deprecated-the-security-auto-configuration
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private AuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// When you dont want username and password
		//http.authorizeRequests().anyRequest().permitAll();
		
		// when you want username and password
		http.csrf().disable()
			.authorizeRequests().anyRequest()
			.authenticated()
			.and()
			.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        	.withUser("test").password("{noop}test").roles("USER")
        	.and()
        	.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
}