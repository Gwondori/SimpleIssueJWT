package com.minirecord.issuejwt.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User entity: 일반 사용자 정보를 담는 테이블
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@Column(name = "login_type")
	private int loginType;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "agreement1")
	private boolean agreement1;
	@Column(name = "agreement2")
	private boolean agreement2;
	@Column(name = "agreement3")
	private boolean agreement3;
	@Column(name = "agreement4")
	private boolean agreement4;
	@Column(name = "token")
	private String token;
	@Column(name = "issuance_time")
	private String issuanceTime;
	@Column(name = "expiration_time")
	private String expirationTime;
	@Column(name = "status")
	private int status;
}
