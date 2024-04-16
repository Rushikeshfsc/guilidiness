package com.guielidnes.fluidscapes.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter{

	private static final HttpServletRequest HttpServletRequest = null;
	private JWTTokenProvider  jwtTokenprovider;
	
	public JwtTokenFilter(JWTTokenProvider jwtTokenProvider) {
		this.jwtTokenprovider=jwtTokenprovider;
	}
	


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String token=jwtTokenprovider.resolveToken(HttpServletRequest);
		System.out.print("token------"+token);
		
		
		try {
				
			if(jwtTokenprovider.validateToken(token)) {
				String username=jwtTokenprovider.getUsername(token);
				String tenat=jwtTokenprovider.getAudienceFromToken(token);
				UserDetails userDetails=jwtTokenprovider.getUsersInfo(username);
				//System.out.println("users......."+userDetails.toString());
				UsernamePasswordAuthenticationToken auth=jwtTokenprovider.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(auth);
				}
			
			}
		catch(Exception ex) {
				
				SecurityContextHolder.clearContext();
				//response.sendError(ex.getHttpStatus().value(),"Expired or invalide jwt token");
				
		return;
		
//			}catch (com.guielidnes.fluidscapes.exception.Exception ex) {
//				ex.printStackTrace();
//				SecurityContextHolder.clearContext();
//				response.sendError(HttpStatus.UNAUTHORIZED.value(),ex.getMessage());
//				return;
//				
//				
			}
		filterChain.doFilter(HttpServletRequest, response);
	}
	}
	

