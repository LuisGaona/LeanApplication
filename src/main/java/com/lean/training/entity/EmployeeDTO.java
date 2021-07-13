package com.lean.training.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeDTO {
private Long id;
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Long personId;
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Long positionId;
private BigDecimal salary;
private PersonDTO person;
private PositionDTO position;
}
