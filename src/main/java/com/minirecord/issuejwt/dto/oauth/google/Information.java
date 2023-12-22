package com.minirecord.issuejwt.dto.oauth.google;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Information
{
	private String iss;
	private String azp;
	private String aud;
	private String sub;
	private String email;
	private String emailVerified;
	private String atHash;
	private String iat;
	private String exp;
	private String name;
	private String picture;
	private String givenName;
	private String familyName;
	private String locale;
	private String alg;
	private String kid;
	private String typ;
}
