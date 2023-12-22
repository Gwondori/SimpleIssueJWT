package com.minirecord.issuejwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils
{
	public static String createToken(String userEmail, long expireTimeMs, String key) {
		Claims claims = Jwts.claims();
		claims.put("email", userEmail);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact();
	}
}
