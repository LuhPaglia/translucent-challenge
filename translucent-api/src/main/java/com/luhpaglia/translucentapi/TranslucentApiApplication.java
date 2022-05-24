package com.luhpaglia.translucentapi;

import com.luhpaglia.translucentapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslucentApiApplication implements CommandLineRunner {

	@Autowired
	private GameService service;

	public static void main(String[] args) {
		SpringApplication.run(TranslucentApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.createDataBase();
	}
}
