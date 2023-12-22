package com.minirecord.issuejwt.dto.normal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class User
{
	private Long idx;
	private int loginType;
	private String email;
	private String password;
	private boolean agreement1;
	private boolean agreement2;
	private boolean agreement3;
	private boolean agreement4;
	private String token;
	private String issuanceTime;
	private String expirationTime;
	private int status;

	public static User fromEntity(com.minirecord.issuejwt.entity.User user)
	{
		return User.builder()
				.idx(user.getIdx())
				.loginType(user.getLoginType())
				.email(user.getEmail())
				.password(user.getPassword())
				.agreement1(user.isAgreement1())
				.agreement2(user.isAgreement2())
				.agreement3(user.isAgreement3())
				.agreement4(user.isAgreement4())
				.token(user.getToken())
				.issuanceTime(user.getIssuanceTime())
				.expirationTime(user.getExpirationTime())
				.status(user.getStatus())
				.build();
	}
}
