package com.example.clonepjtairbb.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	@GetMapping("/api/user/signup")
	public ResponseEntity<Message> signup(SignUpRequest signUpRequest) {

		return userService.signup(signUpRequest);
	}

	@PostMapping(value ="/api/user/signin")
	public ResponseEntity<Message> signIn(
		@RequestBody SignInRequest signInRequest,
		HttpServletResponse response
		) {
		return userService.signIn(signInRequest, response);
	}



}
