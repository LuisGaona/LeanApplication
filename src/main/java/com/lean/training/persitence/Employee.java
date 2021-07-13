package com.lean.training.persitence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NonNull
	@EmbeddedId
    private EmployeePositionPK id;
	@NonNull
	private BigDecimal salary;
	
	@ManyToOne
	@JoinColumn(name="person",insertable = false,updatable = false)
    //@JsonBackReference
	private Person person;
  
	@ManyToOne
	@JoinColumn(name="position",insertable = false,updatable = false)
    @JsonBackReference
	private Position position;
	



}
