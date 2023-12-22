package com.minirecord.issuejwt.controllers;

import com.minirecord.issuejwt.dto.normal.*;
import com.minirecord.issuejwt.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/normal")
public class NormalLoginController
{
	private final UserService userService;

	/**
	 * Simple user registration
	 * @param requestRegister: (form-data)Request DTO
	 * @return ResponseRegister: (Result)Response DTO
	 */
	@PostMapping("/register")
	public ResponseEntity<ResponseRegister> register(RequestRegister requestRegister)
	{
		try
		{
			User newUser = userService.register(requestRegister);
			return new ResponseEntity<>(new ResponseRegister(newUser.getEmail()), HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(new ResponseRegister(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Simple user login
	 * @param requestLogin: (form-data)Request DTO for Login
	 * @return ResponseLogin: (Result)Response DTO for Login
	 */
	@PostMapping("/login")
	public ResponseEntity<ResponseLogin> login(RequestLogin requestLogin)
	{
		try
		{
			String token = userService.login(requestLogin.getEmail(), requestLogin.getPassword());
			// TODO: Base64 encoding
			// TODO: Save Token to DB and set expiration time(expiration time is in 'tokenValidTime' variable in UserService.java)

			return new ResponseEntity<>(new ResponseLogin(token), HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(new ResponseLogin(e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
	}
}
