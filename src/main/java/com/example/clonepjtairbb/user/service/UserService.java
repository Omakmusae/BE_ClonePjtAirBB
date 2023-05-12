package com.example.clonepjtairbb.user.service;

import com.example.clonepjtairbb.common.utils.Message;
import com.example.clonepjtairbb.dependency.UserServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public class UserService implements UserServiceInterface {
    public ResponseEntity<Message> loginRequest() {
        return null;
    }

}
