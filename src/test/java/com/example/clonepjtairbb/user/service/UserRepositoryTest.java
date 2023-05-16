package com.example.clonepjtairbb.user.service;

import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.TestPropertySource;

import com.example.clonepjtairbb.user.entity.User;
import com.example.clonepjtairbb.user.repository.UserRepository;


@TestPropertySource(locations = "/application.properties")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@AfterEach
	public void cleanup(){
		userRepository.deleteAll();
	}

	@Test
	public void find() {

		List<User> result = userRepository.findAll();
		for (User user : result) {
			System.out.println(user.toString());
		}

	}
}
