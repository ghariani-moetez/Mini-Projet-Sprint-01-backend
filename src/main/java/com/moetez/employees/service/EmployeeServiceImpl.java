package com.moetez.employees.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moetez.employees.dto.EmployeeDTO;
import com.moetez.employees.entities.Departement;
import com.moetez.employees.entities.Employee;
import com.moetez.employees.repos.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	@Lazy
	ModelMapper modelMapper;
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO e) {
		return convertEntityToDto (employeeRepository.save(convertDtoToEntity(e)));
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO e) {
		return convertEntityToDto(employeeRepository.save(convertDtoToEntity(e)));
		
	}

	@Override
	public void deleteEmployee(Employee e) {
		employeeRepository.delete(e);		
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);		
	}

	@Override
	public EmployeeDTO getEmployee(Long id) {
		return convertEntityToDto(employeeRepository.findById(id).get());
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public Page<Employee> getAllEmployeesParPage(int page, int size) {
		return employeeRepository.findAll(PageRequest.of(page, size));

	}

	@Override
	public List<Employee> findByNomEmployee(String nom) {
		return employeeRepository.findByNomEmployee(nom);
	}

	@Override
	public List<Employee> findByNomEmployeeContains(String nom) {
		return  employeeRepository.findByNomEmployeeContains(nom);
	}

	@Override
	public List<Employee> findByNomSalaire(String nom, Double salaire) {
		return employeeRepository.findByNomSalaire(nom,salaire);
	}
	@Override
	public List<Employee> findByDepartement(Departement departement) {
		return employeeRepository.findByDepartement(departement);
	}

	@Override
	public List<Employee> findByDepartementIdDep(Long id) {
		return employeeRepository.findByDepartementIdDep(id);
	}

	@Override
	public List<Employee> findByOrderByNomEmployeeAsc() {
		return employeeRepository.findByOrderByNomEmployeeAsc();
	}

	@Override
	public List<Employee> trierEmployeesNomsSalaire() {
		return employeeRepository.trierEmployeesNomsSalaire();
	}

	@Override
	public EmployeeDTO convertEntityToDto(Employee employee) {
		/*return EmployeeDTO.builder()
				.idEmployee(employee.getIdEmployee())
				.nomEmployee(employee.getNomEmployee())
				.salaire(employee.getSalaire())
				.dateEmbauche(employee.getDateEmbauche())
				.departement(employee.getDepartement())
				//.nomDep(employee.getDepartement().getNomDep())
				.build();*/
		modelMapper.getConfiguration().setMatchingStrategy((MatchingStrategies.LOOSE));
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		 return employeeDTO; 
		
	}

	@Override
	public Employee convertDtoToEntity(EmployeeDTO employeeDto) {
		Employee employee=new Employee();
		employee= modelMapper.map(employeeDto,Employee.class);
		return employee;
		/*Employee employee = new Employee();
		employee.setIdEmployee(employeeDto.getIdEmployee());
		employee.setNomEmployee(employeeDto.getNomEmployee());
		employee.setSalaire(employeeDto.getSalaire());
		employee.setDateEmbauche(employeeDto.getDateEmbauche());
		employee.setDepartement(employeeDto.getDepartement());
		 return employee; */
	}

}
