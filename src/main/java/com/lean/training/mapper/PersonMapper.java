package com.lean.training.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.lean.training.entity.PersonDTO;
import com.lean.training.persitence.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonDTO toPersonDTO(Person person);
	@InheritInverseConfiguration
	Person toPerson(PersonDTO personDto);
}
