package com.john.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.demo.bean.Entity;
import com.john.demo.repo.CriteriaExecutor;

@RestController
@RequestMapping("/criteria")
public class CriteriaController {

	@Autowired
	CriteriaExecutor executor;
	
	@GetMapping("/entities")
	public List<?> getAllEntities(@RequestParam(value = "expand", required = false) String expand){
		if(expand !=null)
			return executor.getAllEntitieswithOwnership();
		else
			return executor.getAllEntities();
	}
	
	@GetMapping("/entities/{id}")
	public Entity getAEntity(@PathVariable int id){
		return executor.getAEntity(id);
	}
	
	
}
