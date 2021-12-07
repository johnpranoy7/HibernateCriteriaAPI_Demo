package com.john.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.john.demo.bean.Entity;
import com.john.demo.repo.EntityRepo;
import com.john.demo.repo.OwnershipRepo;

@RestController
public class EntityController {

	@Autowired
	EntityRepo entityRepo;
	
	@Autowired
	OwnershipRepo ownershipRepo;
	
	@GetMapping("/entities")
	public List<Entity> getEntities() {
		return entityRepo.findAll();
	}
	
	@GetMapping("/entities/{entityId}")
	public Optional<Entity> getEntity(@PathVariable int entityId) {
		return entityRepo.findById(entityId);
	}
	
	@PostMapping("/entities")
	public Entity postEntities(@RequestBody Entity entity) {
		return entityRepo.save(entity);
	}
}
