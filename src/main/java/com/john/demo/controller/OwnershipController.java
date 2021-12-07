package com.john.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.john.demo.bean.Ownership;
import com.john.demo.repo.EntityRepo;
import com.john.demo.repo.OwnershipRepo;

@RestController
public class OwnershipController {

	@Autowired
	EntityRepo entityRepo;

	@Autowired
	OwnershipRepo ownershipRepo;

	@GetMapping("/entities/{entityId}/ownedBy")
	public List<Ownership> getOwnership(@PathVariable int entityId) {
		return ownershipRepo.findByEntity(entityRepo.findById(entityId));
	}

	@GetMapping("/ownedBy")
	public List<Ownership> getAllOwnership() {
		return ownershipRepo.findAll();
	}

	@PostMapping("/ownedBy")
	public Ownership postEntities(@RequestBody Ownership ownership) {
		return ownershipRepo.save(ownership);
	}

}
