package com.john.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.john.demo.bean.Entity;
import com.john.demo.bean.Ownership;

public interface OwnershipRepo extends JpaRepository<Ownership, Integer>{

	List<Ownership> findByEntity(Optional<Entity> optional);


}
