package io.github.extrabalho.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

	 @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	                .httpBasic()
	                .and()
	                .authorizeHttpRequests()
//	                .requestMatchers(HttpMethod.GET, "/api/pessoa").permitAll()
	                .requestMatchers(HttpMethod.POST, "/api/usuario/**").permitAll()
	                .requestMatchers(HttpMethod.POST, "/api/usuario").permitAll()
//	                .requestMatchers(HttpMethod.POST, "/api/role").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .csrf().disable();

	        return http.build();
	    }

	 @Bean
	 PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}
