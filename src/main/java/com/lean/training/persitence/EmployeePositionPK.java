package com.lean.training.persitence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EmployeePositionPK implements Serializable {
	@Column(name="id")
	private Long employeeId;
	@Column(name = "person")
	private Long personId;
	@Column(name = "position")
	private Long positionId;
}
