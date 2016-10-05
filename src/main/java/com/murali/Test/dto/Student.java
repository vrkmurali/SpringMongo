package com.murali.Test.dto;

import java.io.Serializable;

public class Student implements Serializable{
	
	private int age;
	private String UUID;
	private String id;
	
	private String name;

	
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
}
