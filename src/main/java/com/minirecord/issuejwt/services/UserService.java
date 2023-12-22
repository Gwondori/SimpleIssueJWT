package com.minirecord.issuejwt.services;

import com.minirecord.issuejwt.dto.normal.RequestRegister;
import com.minirecord.issuejwt.dto.normal.User;
import com.minirecord.issuejwt.jpa.UserRepository;

import com.minirecord.issuejwt.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService
{
	private final UserRepository userRepository;

	@Value("${jwt.token.secret}")
	private String secretKey;
	private final long tokenValidTime = 1000 * 60 * 60;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Register for normal user
	 * @param newUser: user for register
	 * @return User
	 */
	public User register(RequestRegister newUser)
	{
		userRepository.findByEmail(newUser.getEmail()).ifPresent(u -> {
			throw new RuntimeException("이미 가입되어 있는 유저입니다.");
		});

		com.minirecord.issuejwt.entity.User savedUser = userRepository.save(newUser.toEntity(bCryptPasswordEncoder.encode(newUser.getPassword())));

		return User.fromEntity(savedUser);
	}

	/**
	 * Login for normal user
	 * @param userEmail: user email
	 * @param password: user password
	 * @return: token
	 */
	public String login(String userEmail, String password)
	{
		com.minirecord.issuejwt.entity.User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("가입되지 않은 유저입니다."));

		if (!bCryptPasswordEncoder.matches(password, user.getPassword()))
		{
			throw new RuntimeException("잘못된 비밀번호입니다.");
		}

		return JwtUtils.createToken(userEmail, tokenValidTime, secretKey);
	}
}
