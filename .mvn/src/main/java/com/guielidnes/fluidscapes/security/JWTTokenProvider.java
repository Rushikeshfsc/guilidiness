package com.guielidnes.fluidscapes.security;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.sym.Name;
import com.guielidnes.fluidscapes.entity.LoginRequest;
import com.guielidnes.fluidscapes.entity.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javassist.NotFoundException;

@Component
public class JWTTokenProvider {

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKay;
	
	//3600000 mili sec=1h
	
	@Value("${security.jwt.token.expire-length:300}")
	private long validityInMillisecond=300;
	
	
	@Autowired
	private MyUserDeatil userdetail;
	
	@PostConstruct
	protected void init() {
		
		secretKay=Base64.getEncoder().encodeToString(secretKay.getBytes());
		
	}
	
	public String createToken(String username,String type) {
		
		List<String> appuserroles=new ArrayList<>();
		
		appuserroles.add(type);
		Claims claims=Jwts.claims().setSubject(username);
		if(type==null || type.isEmpty()){
			type="USER";
		}
claims.put("auth",appuserroles.stream().map(s-> new SimpleGrantedAuthority(s)).filter(Objects::nonNull).collect(Collectors.toList()));

    Date now=new Date();
    
    Date validity=new Date(now.getTime()+validityInMillisecond);

   return Jwts.builder()
		   .setClaims(claims)
		   .setIssuedAt(now)
		   .setExpiration(validity)
		   .signWith(SignatureAlgorithm.HS256,secretKay)
		   .compact();
		   
		   
	}
	
	public UsernamePasswordAuthenticationToken getAuthentication(String token) {
		
	 Users user =userdetail.findByUsername(getUsername(token));
	       
	return new UsernamePasswordAuthenticationToken(user,((org.springframework.security.core.Authentication) user).getAuthorities());
	
	       	
}

	public String getUsername(String token) {
		
		return Jwts.parser().setSigningKey(secretKay).parseClaimsJws(token).getBody().getSubject();
	}
	
	public String getAudienceFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKay).parseClaimsJws(token).getBody().getAudience();
		
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearerToken=req.getHeader("Authorization");
		if(bearerToken !=null && bearerToken.startsWith("Bearer")) {
			
			return bearerToken.substring(7);
		}
		
		return null;
	}
	
	public UserDetails getUsersInfo(String username) throws NotFoundException {
		return (UserDetails) userdetail.findByUsername(username);
	}
	
	
	public boolean validateToken(String token) {
		
		Jwts.parser().setSigningKey(secretKay).parseClaimsJws(token);
		return true;
	}
	
	
}




