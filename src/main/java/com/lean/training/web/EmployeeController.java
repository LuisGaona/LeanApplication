package com.lean.training.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lean.training.entity.EmployeeDTO;
import com.lean.training.entity.PositionDTO;
import com.lean.training.exception.RecordNotFoundException;
import com.lean.training.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	/*
	 * @GetMapping public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
	 * List<EmployeeDTO> list = service.getAllEmployees();
	 * 
	 * return new ResponseEntity<List<EmployeeDTO>>(list,HttpStatus.OK); }
	 */

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
			@RequestParam(value = "name", defaultValue = "null") String name,
			@RequestParam(value = "positionId", defaultValue = "0") Long positionId) {
		List<EmployeeDTO> list = service.getByPositionOrEmployeeName(positionId, name);

		return new ResponseEntity<List<EmployeeDTO>>(list, HttpStatus.OK);
	}

	@GetMapping("/positions/getAllRoles")
	public ResponseEntity<List<PositionDTO>> getAllPositions() {
		List<PositionDTO> list = service.getAllPositions();
		return new ResponseEntity<List<PositionDTO>>(list, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employee) {
		return new ResponseEntity<EmployeeDTO>(service.save(employee), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee) throws RecordNotFoundException {
		EmployeeDTO updated = service.updateEmployee(employee);
		return new ResponseEntity<EmployeeDTO>(employee, new HttpHeaders(), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		if (service.deleteEmployeeById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
