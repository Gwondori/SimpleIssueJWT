package com.minirecord.issuejwt.controllers;

import com.minirecord.issuejwt.dto.oauth.google.Information;
import com.minirecord.issuejwt.dto.oauth.google.Request;
import com.minirecord.issuejwt.dto.oauth.google.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// NOTE: Before using this feature, GCP will set up an authorized redirect URL for you.
@RestController
@RequestMapping("/auth/google")
public class GoogleLoginController
{
	private final String clientId = "907631430385-5ia8ukqqjb48itn4n3jo7gm9uqr58ufa.apps.googleusercontent.com";
	private final String clientSecretPasswd = "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";

	/**
	 * login(): Login with Google(/auth/google/login)
	 * @param authCode: Google OAuth2.0 Authentication code
	 * @return Map<String, String>
	 */
	@GetMapping("/login")
	public Map<String, String> login(@RequestParam(value = "code") String authCode)
	{
		Map<String, String> response = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();
		Request request = Request.builder()
				.code(authCode)
				.clientId(clientId)
				.clientSecret(clientSecretPasswd)
				.redirectUri("http://localhost:8080/login/google")
				.grantType("authorization_code")
				.build();
		ResponseEntity<Response> googleResponse = restTemplate.postForEntity("https://oauth2.googleapis.com/token", request, Response.class);
		String jwt = Objects.requireNonNull(googleResponse.getBody()).getIdToken();
		Map<String, String> map = new HashMap<>()
		{{
			 put("id_token", jwt);
		}};
		ResponseEntity<Information> googleResponse2 = restTemplate.postForEntity("https://oauth2.googleapis.com/token-info", map, Information.class);
		String userEmail = Objects.requireNonNull(googleResponse2.getBody()).getEmail();

		// TODO: Save the jwt and userEmail to the database.
		System.out.println("JWT: " + jwt);
		System.out.println("User Email: " + userEmail);

		response.put("status", "0");
		response.put("message", "Login Success");
		response.put("user_email", userEmail);
		response.put("token", jwt);

		return response;
	}

	/**
	 * getLoginUrl(): Get Google OAuth2.0 Login URL(/auth/google/url)
	 * @return String: Google OAuth2.0 Login URL
	 */
	@PostMapping("/url")
	public String getLoginUrl()
	{
		return "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + clientId + "&redirect_uri=http://localhost:8080/google-login&response_type=code&scope=openid%20email%20profile";
	}
}
