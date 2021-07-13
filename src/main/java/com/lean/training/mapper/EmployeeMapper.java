package com.lean.training.mapper;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.lean.training.entity.EmployeeDTO;
import com.lean.training.persitence.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	@Mappings({
	@Mapping(source = "id.employeeId",target = "id"),
	@Mapping(source = "id.personId",target = "personId"),
	@Mapping(source = "id.positionId",target = "positionId")
	})
	EmployeeDTO toEmployeDto(Employee employee);
	List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees);
	@InheritInverseConfiguration
	Employee toEmployee(EmployeeDTO employeeDto);
	

}
