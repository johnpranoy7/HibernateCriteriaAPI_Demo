package com.john.demo.bean;

import javax.persistence.Id;

@javax.persistence.Entity
public class City {
	
	@Id
	int id;
	String name;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
