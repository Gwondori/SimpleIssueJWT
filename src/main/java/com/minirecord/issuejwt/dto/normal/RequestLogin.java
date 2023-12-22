package com.minirecord.issuejwt.dto.normal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestLogin
{
	private String email;
	private String password;
}
