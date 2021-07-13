package com.lean.training.entity;

import java.util.Set;

import com.lean.training.persitence.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO {
private String name;
private String lastName;
private String address;
private String cellphone;
private String cityName;
}
