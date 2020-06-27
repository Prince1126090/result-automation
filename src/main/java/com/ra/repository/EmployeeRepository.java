package com.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
