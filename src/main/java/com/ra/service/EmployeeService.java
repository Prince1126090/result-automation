package com.ra.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ra.entity.Employee;
import com.ra.entity.Employee.Gender;
import com.ra.exception.ResourceNotFoundException;
import com.ra.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee update(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = findById(employeeId);
		employee.setName(employeeDetails.getName());
		employee.setContactNumber(employeeDetails.getContactNumber());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setEmail(employeeDetails.getEmail());
		employee.setGender(employeeDetails.getGender());
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
	
	public void delete(Long employeeId) throws ResourceNotFoundException {
		Employee employee = findById(employeeId);
		employeeRepository.delete(employee);
	}
	
	public Employee findById(Long employeeId) throws ResourceNotFoundException {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	}

	public List<Employee> getList() {
		List<Employee> employeeList;
		employeeList = employeeRepository.findAll();
		if (employeeList == null || employeeList.isEmpty()) {
			createSampleEmployees();
			employeeList = employeeRepository.findAll();
		}
		return employeeList;
	}

	private void createSampleEmployees() {
		Employee employeeOne = new Employee();
		employeeOne.setName("Prince");
		employeeOne.setContactNumber("01781024196");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "05/01/1995";
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employeeOne.setDateOfBirth(date);
		employeeOne.setEmail("prince1126090@gmail.com");
		employeeOne.setGender(Gender.MALE);
		create(employeeOne);

		Employee employeeTwo = new Employee();
		employeeTwo.setName("Abir");
		employeeTwo.setContactNumber("01781024188");
		dateInString = "15/05/1996";
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeeTwo.setDateOfBirth(date);
		employeeTwo.setEmail("abir@abcd.com");
		employeeTwo.setGender(Gender.MALE);
		create(employeeTwo);
	}

}
