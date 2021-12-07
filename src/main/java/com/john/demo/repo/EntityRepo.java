package com.john.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.john.demo.bean.Entity;

public interface EntityRepo extends JpaRepository<Entity, Integer>{


}
