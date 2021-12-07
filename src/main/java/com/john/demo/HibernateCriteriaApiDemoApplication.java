package com.john.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.john.demo.bean.Entity;
import com.john.demo.repo.CriteriaExecutor;
import com.john.demo.repo.OwnershipRepo;

@SpringBootApplication
public class HibernateCriteriaApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCriteriaApiDemoApplication.class, args);
		
		CriteriaExecutor repo = new CriteriaExecutor();
		List<Entity> allEntitiesProjections = repo.getAllEntitiesProjections();
		
		System.out.println(allEntitiesProjections);
	}

}
