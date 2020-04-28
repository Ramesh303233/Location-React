package com.bharath.location.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {

	
	
	@Id
	//@Column(name = "id")
	int id;

	//@Column(name = "Code")
	String code;

	//@Column(name = "type")
	String type;

	//@Column(name = "name")
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", type=" + type + ", name=" + name + "]";
	}

	
	
}
