package com.devsuperior.uri2737;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.repositories.LawyerRepository;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<LawyerMinDTO> resultSQL = repository.search1()
				.stream().map(x -> new LawyerMinDTO(x)).toList();
		
		
		for (LawyerMinDTO sqlDTO : resultSQL) {
			System.out.println(sqlDTO);
		}

	}
}
