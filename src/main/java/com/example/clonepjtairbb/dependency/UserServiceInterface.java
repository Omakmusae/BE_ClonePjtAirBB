package com.example.clonepjtairbb.dependency;

import com.example.clonepjtairbb.user.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    public ResponseEntity<?> loginRequest();

}
