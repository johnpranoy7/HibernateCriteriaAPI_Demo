package com.john.demo.bean;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@javax.persistence.Entity
public class Ownership {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ownershipName;
	@ManyToOne
	@JoinColumn(name = "entityId", nullable = false)
//	@JsonBackReference
	private Entity entity;

	public Ownership() {
	}

	public Ownership(int id, String ownershipName, Entity entity) {
		this.id = id;
		this.ownershipName = ownershipName;
		this.entity = entity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnershipName() {
		return ownershipName;
	}

	public void setOwnershipName(String ownershipName) {
		this.ownershipName = ownershipName;
	}


}
