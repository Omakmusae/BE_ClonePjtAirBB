package com.example.clonepjtairbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ClonePjtAirBbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClonePjtAirBbApplication.class, args);
	}
	//주석
}
