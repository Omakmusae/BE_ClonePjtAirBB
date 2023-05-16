package com.example.clonepjtairbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

@EnableJpaAuditing
@SpringBootApplication
public class ClonePjtAirBbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClonePjtAirBbApplication.class, args);
	}
}
