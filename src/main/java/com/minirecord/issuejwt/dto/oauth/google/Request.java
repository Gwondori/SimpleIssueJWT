package com.minirecord.issuejwt.dto.oauth.google;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request
{
	private String code;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private String grantType;
	private String accessType;
	private String scope;
	private String state;
	private String includeGrantedScopes;
	private String loginHint;
	private String responseType;
	private String prompt;
}
