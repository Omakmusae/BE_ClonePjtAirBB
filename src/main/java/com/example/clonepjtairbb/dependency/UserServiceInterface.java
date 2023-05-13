package com.example.clonepjtairbb.dependency;

import com.example.clonepjtairbb.user.dto.SignInRequest;
import com.example.clonepjtairbb.user.entity.User;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletResponse;

public interface UserServiceInterface {
    public void signIn(SignInRequest signInRequest, HttpServletResponse response);

}
