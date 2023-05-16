package com.example.clonepjtairbb.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.clonepjtairbb.common.utils.Message;
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
	public ResponseEntity<Message> signup(@RequestBody SignUpRequest signUpRequest) {

		userService.signup(signUpRequest);
		return ResponseEntity.ok(new Message("회원가입 완료"));
	}

	@PostMapping(value ="/api/user/signin")
	public ResponseEntity<Message> signIn(
		@RequestBody SignInRequest signInRequest,
		HttpServletResponse response
		) {
			userService.signIn(signInRequest, response);
		return ResponseEntity.ok(new Message("로그인 완료"));
	}
}
