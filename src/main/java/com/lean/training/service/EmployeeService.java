package com.lean.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lean.training.entity.EmployeeDTO;
import com.lean.training.entity.PositionDTO;
import com.lean.training.exception.RecordNotFoundException;
import com.lean.training.mapper.EmployeeMapper;
import com.lean.training.mapper.PositionMapper;
import com.lean.training.persitence.Employee;
import com.lean.training.persitence.Position;
import com.lean.training.repository.EmployeeRepository;
import com.lean.training.repository.PositionRepository;
@Transactional
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	@Autowired
	EmployeeMapper mapper;
	@Autowired
	PositionMapper positionMapper;
	@Autowired
	PositionRepository positionRepository;
	
	public List<EmployeeDTO> getAllEmployees()
    {
        List<EmployeeDTO> employeeList =  mapper.toEmployeeDTOs(repository.findAll());
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeDTO>();
        }
    }
	
	public List<EmployeeDTO> getByPositionOrEmployeeName(Long positionId, String name) {
		List<EmployeeDTO> employeeList = mapper
				.toEmployeeDTOs(repository.findByPosition_IdOrPerson_Name(positionId, name));

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeDTO>();
		}
	}
	
	public EmployeeDTO save(EmployeeDTO employee) {
		return  mapper.toEmployeDto(repository.save(mapper.toEmployee(employee)));
	}
	
    public EmployeeDTO updateEmployee(EmployeeDTO entity) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findByIdEmployeeId(entity.getId());
         
        if(employee.isPresent())
        {
        	Employee employeeUpdate=mapper.toEmployee(entity);
            return mapper.toEmployeDto(repository.save(employeeUpdate));
        } else {
        	 throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
    
	public boolean deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findByIdEmployeeId(id);
         
        if(employee.isPresent())
        {
            repository.deleteByIdEmployeeId(id);
            return true;
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
	
	/**No Funcion*/
	public List<PositionDTO> getAllPositions()
    {
        List<PositionDTO> positionList =  positionMapper.toPositionDTOs(positionRepository.findAll());
        positionList.stream().forEach((c) -> /*System.out.println(c)*/ c.getEmployeesss().stream().forEach((p)-> p.setPosition(null)));
        if(positionList.size() > 0) {
            return positionList;
        } else {
            return new ArrayList<PositionDTO>();
        }
    } 
    
}
