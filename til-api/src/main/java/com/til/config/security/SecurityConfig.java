package com.til.config.security;

import static org.springframework.security.config.http.SessionCreationPolicy.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.formLogin(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.csrf(AbstractHttpConfigurer::disable)
			.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()))
			.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
			.authorizeHttpRequests((request) -> request
				.requestMatchers(HttpMethod.GET, "/user/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/user/**").permitAll()
				.anyRequest().authenticated());

		return http.build();
	}
}
