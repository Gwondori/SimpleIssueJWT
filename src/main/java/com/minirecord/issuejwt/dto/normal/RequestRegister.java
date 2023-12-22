package com.minirecord.issuejwt.dto.normal;

import com.minirecord.issuejwt.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class RequestRegister
{
	private String email;
	private String password;

	public User toEntity(String password)
	{
		return User.builder()
				.email(this.email)
				.password(password)
				.build();
	}
}
