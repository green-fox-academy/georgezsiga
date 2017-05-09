package com.greenfox;

import com.greenfox.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosqlApplication implements CommandLineRunner {

	@Autowired
	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(TodosqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
