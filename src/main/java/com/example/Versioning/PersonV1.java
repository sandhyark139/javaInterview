package com.example.Versioning;

public class PersonV1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public PersonV1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}
	
}
