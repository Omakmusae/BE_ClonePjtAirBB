package com.example.clonepjtairbb.user.service;

import java.util.Optional;

import com.example.clonepjtairbb.dependency.UserServiceInterface;
import com.example.clonepjtairbb.user.dto.SignInRequest;
import com.example.clonepjtairbb.user.dto.SignUpRequest;
import com.example.clonepjtairbb.user.entity.User;
import com.example.clonepjtairbb.common.utils.JwtUtil;
import com.example.clonepjtairbb.user.repository.UserRepository;

import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";


    @Transactional
    public void signup(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        String nickname = signUpRequest.getNickname();

        // 회원 중복 확인
        Optional<User> found = userRepository.findByEmail(email);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        User user = new User(email, password, nickname);
        userRepository.save(user);

    }

    @Transactional
    public void signIn(SignInRequest signInRequest, HttpServletResponse response) {
        String email = signInRequest.getEmail();
        String password = signInRequest.getPassword();

        // 사용자 확인
        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // 비밀번호 확인
        if(!user.getPassword().equals(password)){
            throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        //response cookie에 jwt 토큰을 추가
        response.addCookie(new Cookie(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getEmail(), user.getNickname())));

    }

}
