package com.lean.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lean.training.persitence.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long > {
	
	public List<Employee> findByPosition_IdOrPerson_Name(Long positionId,String name);
	Optional<Employee> findByIdEmployeeId(Long id);
	void deleteByIdEmployeeId(Long id);
	


}
