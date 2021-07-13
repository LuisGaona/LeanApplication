package com.lean.training.persitence;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long personId;
	private String name;
	@Column(name = "last_name")
	private String lastName;
	private String address;
	private String cellphone;
	@Column(name = "city_name")
	private String cityName;
	
	/*
	 @OneToMany(mappedBy = "person")
	 private Set<Employee> employees;
	 */
	

	
	
}
