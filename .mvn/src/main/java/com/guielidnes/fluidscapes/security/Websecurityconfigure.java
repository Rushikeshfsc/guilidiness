package com.guielidnes.fluidscapes.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class Websecurityconfigure extends WebSecurityConfigurerAdapter{
	
	public static final Logger logger=LoggerFactory.getLogger(Websecurityconfigure.class);
	@Autowired
	private  JWTTokenProvider jwtTokenProvider;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable();
		http.cors();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.authorizeHttpRequests()
		.antMatchers("/admin/login").permitAll()
		.antMatchers("/swagger-ui/index.html").permitAll()
		.antMatchers("/v2/api-docs").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/public").permitAll()
		.antMatchers("/**").permitAll()
		.anyRequest().authenticated();
		
    http.apply(new JwtTokenFilterConfigure(jwtTokenProvider));//applay when if user try to access a resorce without having enough permission
		
//http.httpBasic((Customizer<HttpBasicConfigurer<HttpSecurity>>) new JwtTokenFilterConfigure(jwtTokenProvider));
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		
		web.ignoring().antMatchers("/v2/api-docs")
		.antMatchers("/swagger-resources/**")
		.antMatchers("/swagger-ui.html")
		.antMatchers("/configuration")
		.antMatchers("/webjars/**")
		.antMatchers("/public")
		.antMatchers("/login")
		.antMatchers("users/signup")
		.antMatchers("/swagger-ui/index.html");
		
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(12);
		
	}
	
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
}


