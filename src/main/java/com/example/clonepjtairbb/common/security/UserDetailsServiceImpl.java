package com.example.clonepjtairbb.common.security;

import com.example.clonepjtairbb.user.entity.User;
import com.example.clonepjtairbb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new NullPointerException("유저를 찾을 수 없습니다")
        );
        return new UserDetailsImpl(user);
    }
}
