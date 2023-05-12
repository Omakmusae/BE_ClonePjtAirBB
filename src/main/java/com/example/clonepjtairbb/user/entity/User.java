package com.example.clonepjtairbb.user.entity;

import com.example.clonepjtairbb.common.utils.TimeStamped;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;
}
