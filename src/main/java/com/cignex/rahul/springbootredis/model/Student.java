package com.cignex.rahul.springbootredis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Student implements Serializable {

	public enum Gender {
		Male, Female
	}

	private String name;
	private int age;
	private String id;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
