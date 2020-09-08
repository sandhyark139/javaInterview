package com.example.User;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="all details about user (C:sandhya)")
@Entity
@Table(name="sandhya")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@ApiModelProperty(notes="name must be atleast 2 charectors")
	@Size(min=2,message="name shoule be atleast 2 charectors")
	
	private String name;
	@ApiModelProperty(notes="Birthdate must be past date")
	@Past
	private Date DateofBirth;
	
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofBirth() {
		return DateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		DateofBirth = dateofBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DateofBirth=" + DateofBirth + "]";
	}

	public User(Integer id, String name, Date dateofBirth) {
		super();
		this.id = id;
		this.name = name;
		DateofBirth = dateofBirth;
	}
	
	
	
	

}
