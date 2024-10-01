package com.moetez.employees.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.moetez.employees.dto.EmployeeDTO;
import com.moetez.employees.entities.Departement;
import com.moetez.employees.entities.Employee;

public interface EmployeeService {
	EmployeeDTO saveEmployee(EmployeeDTO e);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getEmployee(Long id);

	EmployeeDTO updateEmployee(EmployeeDTO e);
	
	void deleteEmployee(Employee e);
	void deleteEmployeeById(Long id);
	
	
	Page<Employee> getAllEmployeesParPage(int page, int size);
	List<Employee> findByNomEmployee(String nom);
	List<Employee> findByNomEmployeeContains(String nom);
	List<Employee> findByNomSalaire(String nom, Double salaire);
	List<Employee> findByDepartement (Departement departement);
	List<Employee> findByDepartementIdDep(Long id);
	List<Employee> findByOrderByNomEmployeeAsc();
	List<Employee> trierEmployeesNomsSalaire();
	EmployeeDTO convertEntityToDto (Employee employee);
	Employee convertDtoToEntity(EmployeeDTO employeeDto);

}
