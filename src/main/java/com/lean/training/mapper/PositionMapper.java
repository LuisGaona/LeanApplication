package com.lean.training.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.lean.training.entity.EmployeeDTO;
import com.lean.training.entity.PositionDTO;
import com.lean.training.persitence.Employee;
import com.lean.training.persitence.Position;

@Mapper(componentModel = "spring",uses = EmployeeMapper.class)
public interface PositionMapper {
	PositionMapper INSTANCIA= Mappers.getMapper(PositionMapper.class);
	@Mappings({
		@Mapping(source = "employees",target = "employeesss"),
		})
PositionDTO toPositionDTO(Position position);
List<PositionDTO> toPositionDTOs(List<Position> positions);
	
@InheritInverseConfiguration
Position  toPosition(PositionDTO positionDto);


}
