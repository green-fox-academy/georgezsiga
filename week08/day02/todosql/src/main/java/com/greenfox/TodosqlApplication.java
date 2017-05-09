package com.greenfox;

import com.greenfox.Model.ToDo;
import com.greenfox.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosqlApplication implements CommandLineRunner {

	@Autowired
	private ToDoRepository toDoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodosqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
  toDoRepository.save(new ToDo("I want to run"));
  toDoRepository.save(new ToDo("I want to run more"));
  toDoRepository.save(new ToDo("I want to run and more"));
  toDoRepository.save(new ToDo("I want to run and even more"));
	}
}
