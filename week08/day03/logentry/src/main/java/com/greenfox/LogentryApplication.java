package com.greenfox;

import com.greenfox.Repository.LogentryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogentryApplication implements CommandLineRunner {

	@Autowired
	private LogentryRepository logentryRepository;

	public static void main(String[] args) {
		SpringApplication.run(LogentryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
