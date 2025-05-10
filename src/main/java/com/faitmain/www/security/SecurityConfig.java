package com.faitmain.www.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(req -> req
						.requestMatchers("/", "/store/**", "/shoe/**", "/h2/**").permitAll()		// H2 Console
						.anyRequest().permitAll())
				.csrf(csrf -> csrf.disable())
				.build();
		
	}

}
