package com.minirecord.issuejwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController
{
	@PostMapping("/get-token")
	public String getToken(@RequestBody String email)
	{
		// TODO: Check email is valid or not
		// TODO: Get token from DB
		// TODO: Check token is valid by expiration time
		// TODO: If token is valid, return token

		return "login";
	}
}
