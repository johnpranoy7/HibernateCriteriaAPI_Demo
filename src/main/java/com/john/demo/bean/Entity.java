package com.john.demo.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@javax.persistence.Entity
public class Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int entityId;
	private String name;
	private String phoneNo;
	@OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
	private List<Ownership> ownedBy;

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}


	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return entityId;
	}

	public void setId(int id) {
		this.entityId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Entity(int entityId, String name, String phoneNo, List<Ownership> ownedBy) {
		super();
		this.entityId = entityId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.ownedBy = ownedBy;
	}




}
