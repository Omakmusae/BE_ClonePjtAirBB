package com.example.clonepjtairbb.user.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.example.clonepjtairbb.common.utils.Message;
import com.example.clonepjtairbb.common.utils.SuccessResponseEntity;
import com.example.clonepjtairbb.user.dto.SignInRequest;
import com.example.clonepjtairbb.user.dto.SignUpRequest;
import com.example.clonepjtairbb.user.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@PostMapping("/api/user/signup")
	public SuccessResponseEntity<Message> signup(@RequestBody SignUpRequest signUpRequest) {

		userService.signup(signUpRequest);
		return new SuccessResponseEntity<>(new Message("회원가입 완료"), HttpStatus.OK);
	}

	@PostMapping(value ="/api/user/signin")
	public SuccessResponseEntity<Message> signIn(
		@RequestBody SignInRequest signInRequest,
		HttpServletResponse response
		) {
			userService.signIn(signInRequest, response);
		return new SuccessResponseEntity<>(new Message("로그인 완료"), HttpStatus.OK);
	}


}
